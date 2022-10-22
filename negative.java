import java.util.Scanner;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
class negative
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input image path");
        String inputImg = sc.nextLine();
        invertImage(inputImg);
    }
    public static void invertImage(String imageName) 
    {
        Scanner sc = new Scanner(System.in);
        BufferedImage inputFile = null;
        try 
        {
            inputFile = ImageIO.read(new File(imageName));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        for (int x = 0; x < inputFile.getWidth(); x++)
        {
            for (int y = 0; y < inputFile.getHeight(); y++)
            {
                int rgba = inputFile.getRGB(x, y);
                Color col = new Color(rgba, true);
                col = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue());
                inputFile.setRGB(x, y, col.getRGB());
            }
        }
        
        try 
        {
            System.out.println("Enter destination path");
            String outputPath = sc.nextLine();
            File outputFile = new File(outputPath);
            ImageIO.write(inputFile, "png", outputFile);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
