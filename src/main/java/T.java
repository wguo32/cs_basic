import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class T {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String urlStr = input.nextLine();
            String replaceStr = "http://www.X.com/";
            replaceStr = replaceStr.replace("X", urlStr);
            URL x = new URL(replaceStr);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(x.openStream()));

            String inputLine;
            int i=0;
            String [] array=new String[5];
            while ((inputLine = in.readLine()) != null) {
                array[i]=inputLine;
                i++;
                if(i==5){
                    break;
                }

            }
            in.close();
            for (int j = 4; j >=0 ; j--) {
                System.out.println(array[j]);
            }

        }


    }
}
