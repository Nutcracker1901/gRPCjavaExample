package org.example;

import com.example.grpc.MessageProto.MessageRequest;
import com.example.grpc.MessageProto.MessageResponse;
import com.example.grpc.MessageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        MessageServiceGrpc.MessageServiceBlockingStub stub = MessageServiceGrpc.newBlockingStub(channel);

        MessageRequest request = MessageRequest.newBuilder()
                .setMessage("Hello from Java client")
//                .setNumber(5)
                .build();

        MessageResponse response = stub.sendMessage(request);

        System.out.println("Response from server: " + response.getReply());
//        System.out.println(response.getNumber());
        channel.shutdown();
    }
}
