/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package study_buddy;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import java.io.FileInputStream;

/**
 
 * @author invincible
 */
public class DATABASE_CONNECT 
{
 static void Savefile(admin_registerdata AR) 
 {
//      
  try
       {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studybuddy", "root", "tyagi@2314Aryan");
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO data VALUES ('"+AR.getCOURSE()+"','"+AR.getYEAR()+"', '"+AR.getFILE_TYPE()+"','"+AR.getFILE()+"','"+AR.getSUBJECT_CODE()+"')";
        stmt.executeUpdate(sql);
        System.out.println("Data save success");
        
      } catch (SQLException e) {
         e.printStackTrace();
        System.out.println("Error");
         
      } 
}    

    
    static String uploadFile(File selectedFile) {
        
        try
{
            String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=excellence1;AccountKey=rnp1mKth+1YhGsTn2r74DYSJdS/Q33W9crePRMs4NcS1zabHxuDoyxfqQecYb+Pl6xvLYme8UnqW+AStQ5CtGg==;EndpointSuffix=core.windows.net";

	CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
	CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
	CloudBlobContainer container = blobClient.getContainerReference("demo");
	CloudBlockBlob blob = container.getBlockBlobReference(selectedFile.getName());
	blob.upload(new FileInputStream(selectedFile), selectedFile.length());
        return "https://excellence1.blob.core.windows.net/demo/"+selectedFile.getName();
}
catch (Exception e)
{
    // Output the stack trace.
    e.printStackTrace();
}
 return "ERROR";

    
    }
}
