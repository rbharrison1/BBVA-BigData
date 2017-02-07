import java.io.*;
import java.sql.Date;
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
                record.setTAUD_URN(fields[1]);
                record.setTAUD_STP_REG(Date.valueOf(fields[2]));
                record.setTAUD_BRN_ACCT(fields[3]);
                record.setTAUD_ACCT_NTNM(fields[4]);
                record.setTAUD_ACCT_TRM(fields[5]);
                record.setTAUD_DAY_ACCT(fields[6]);
                record.setTAUD_DAT_ACCT(fields[7]);
                record.setTAUD_DAT_OPERATION(fields[8]);
                record.setTAUD_BRN_LOCATION(fields[9]);
                record.setTAUD_NETNAME(fields[10]);
                record.setTAUD_TERMINAL(fields[11]);
                record.setTAUD_USER_ID(fields[12]);
                record.setTAUD_SESSION(fields[13]);
                record.setTAUD_TYP_TERMINAL(fields[14]);
                record.setTAUD_TERMCODE(fields[15]);
                record.setTAUD_DAT_TRMS(fields[16]);
                record.setTAUD_TIM_TRMS(fields[17]);
                record.setTAUD_CICS(fields[18]);
                record.setTAUD_NUM_TASK(Double.valueOf(fields[19]));
                record.setTAUD_COD_START(fields[20]);
                record.setTAUD_FCC(fields[21]);
                record.setTAUD_STATUS(fields[22]);
                record.setTAUD_LNG_TERMINAL(fields[23]);
                record.setTAUD_COD_APP_1(fields[24]);
                record.setTAUD_COD_TRNS_2(fields[25]);
                record.setTAUD_COD_PROGRAM_1(fields[26]);
                record.setTAUD_PASS_CTRL_2(fields[27]);
                record.setTAUD_COD_APP_2(fields[28]);
                record.setTAUD_COD_TRNS_2(fields[29]);



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
