package org.example;

import com.example.grpc.MessageProto.*;
import com.example.grpc.MessageServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new MessageServiceImpl())
                .build();

        System.out.println("Server started...");
        server.start();
        server.awaitTermination();
    }

    static class MessageServiceImpl extends MessageServiceGrpc.MessageServiceImplBase {
        @Override
        public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
            String message = "Ответ сервера";
            int number = request.getNumber();
            number *= number;
            System.out.println("Message received: " + message);
            String reply = "Java server Received: " + message;

            MessageResponse response = MessageResponse.newBuilder()
                    .setReply(reply)
                    .setNumber(number)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
