package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;

import java.io.IOException;
import java.util.Map;

public class HelloFunction {

    public Void handleRequest(CloudEvent event) throws IOException {
        System.out.println("Starting handleRequest" + event.toString());
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map data = objectMapper.convertValue(event.getData().get(), Map.class);
//        Map additionalDetails = objectMapper.convertValue(data.get("additionalDetails"), Map.class);
//        String nameSpace = String.valueOf(additionalDetails.get("namespace"));
//        String bucketName = String.valueOf(additionalDetails.get("bucketName"));
//        String objName = String.valueOf(data.get("resourceName"));

//        String imageUrl = "https://objectstorage.us-phoenix-1.oraclecloud.com/n/" +
//                additionalDetails.get("namespace") +
//                "/b/" +
//                additionalDetails.get("bucketName") +
//                "/o/" +
//                data.get("resourceName");
//        System.out.println("imageUrl: " + imageUrl);
//
//        InputStream imageStream = new URL(imageUrl).openStream();
//        Metadata metadata = ImageMetadataReader.readMetadata(imageStream);
//        System.out.println(objectMapper.writeValueAsString(metadata));

//        return metadata;
        return null;
    }

}