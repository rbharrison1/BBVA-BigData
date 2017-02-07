import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String line;
        String[] fields;
        List<QADTAUD> list = new ArrayList<QADTAUD>();
        QADTAUD record;

        //*************
        // READ IN FILE
        //*************

        //Console c = System.console();
        //System.out.print("File path: ");
        //String path = c.readLine();
        String path = "C:/Users/rharrison15/Desktop/Test Files/shortened.1";

        try {

            FileReader fr = new FileReader(path);

            BufferedReader br = new BufferedReader(fr);

            //*********************
            // SPLIT FILE BY RECORD
            //*********************
            while((line = br.readLine()) != null) {
                //***************************
                // SPLIT EACH RECORD BY FIELD
                //***************************
                fields = line.split("[|]");

                record = null;

                //************************************************************
                // ASSIGN EACH FIELD TO CORRESPONDING MEMBER IN QADTAUD OBJECT
                // ADD OBJECT TO LIST
                //************************************************************

                //1-30 start with TAUD_ENT (Lauryn)
                record.setTAUD_ENT(fields[0]);


                //31-60 start with TAUD_COD_TRNS_2 (Danella)


                //61-90 start with TAUD_EVENT9 (Dallas)


                //91-120 start with TAUD_ENT_ANALYTIC (Taylor)


                //121-142 start with TAUD_AMT_CSHCRE (Ryne)


                list.add(record);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //*********************************
        // CONVERT FROM JAVA OBJECT TO JSON
        //*********************************



        //******************
        // INSERT TO MONGODB
        //******************




    }
}
