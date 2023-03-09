/*package com.example.artsphereincapp;
Microsoft.WindowAzure.storage;
Microsoft.WindowAzure.storage.blob;

public class blobstorage {
    // Create a storage account instance
    StorageAccount storageAccount = new StorageAccount("<myblobstoragetesting>", "<your-storage-account-key>");

    // Get a client to interact with the container
    BlobContainerClient containerClient = storageAccount.createBlobContainerClient("<your-container-name>");

    // Upload a blob to the container
    File file = new File("<path-to-your-file>");
    BlobClient blobClient = containerClient.getBlobClient("<your-blob-name>");
blobClient.upload(file.getInputStream(), file.length(), true);


}
https://myblobstoragetesting.blob.core.windows.net/myfirstcontainer/CW001_CLR_ENG_24_45939283_1.PDF*/
/*private static Boolean upload(String sasUrl, String filePath, String mimeType) {
        try {
        // Get the file data
        File file = new File(filePath);
        if (!file.exists()) {
        return false;
        }

        String absoluteFilePath = file.getAbsolutePath();

        FileInputStream fis = new FileInputStream(absoluteFilePath);
        int bytesRead = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        while ((bytesRead = fis.read(b)) != -1) {
        bos.write(b, 0, bytesRead);
        }
        fis.close();
        byte[] bytes = bos.toByteArray();
        // Post our image data (byte array) to the server
        URL url = new URL(sasUrl.replace("\"", ""));
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setConnectTimeout(15000);
        urlConnection.setReadTimeout(15000);
        urlConnection.setRequestMethod("PUT");
        urlConnection.addRequestProperty("Content-Type", mimeType);
        urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
        urlConnection.setRequestProperty("x-ms-blob-type", "BlockBlob");
        // Write file data to server
        DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
        wr.write(bytes);
        wr.flush();
        wr.close();
        int response = urlConnection.getResponseCode();
        if (response == 201 && urlConnection.getResponseMessage().equals("Created")) {
        return true;
        }
        } catch (Exception e) {
        e.printStackTrace();
        }
        return false;
        }*/