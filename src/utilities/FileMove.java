package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author JWright
 */
public class FileMove
{
    /**
     * This method will copy the file specified to the images directory on this server and give it 
     * a unique name
     */
    public static File copyFileToImagesDirectory(File imageFile) throws IOException
    {
        //create a new Path to copy the image into a local directory
        Path sourcePath = imageFile.toPath();
        
        //String uniqueFileName = getUniqueFileName(imageFile.getName());
        
        Path targetPath = Paths.get("./src/images/"+sourcePath.getFileName());
        
        //copy the file to the new directory
        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        
        return new File(targetPath.toString());
    }
    
    
}
