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


                //61-90 started with TAUD_EVENT9 (Dallas)
                record.setTAUD_EVENT9(fields[61]);
                record.setTAUD_USERAUT9(fields[62]);
                record.setTAUD_EVENT10(fields[63]);
                record.setTAUD_USERAUT10(fields[64]);
                record.setTAUD_DES_INP_CPY(fields[65]);
                record.setTAUD_INP_PANL(fields[66]);
                record.setTAUD_TYP_PROCESS(fields[67]);
                record.setTAUD_NUM_SEQUENCE(fields[68]);
                record.setTAUD_KEY(fields[69]);
                record.setTAUD_ATM(fields[70]);
                record.setTAUD_DTA_INP_MOD(fields[71]);
                record.setTAUD_TYP_MESSAGE(fields[72]);
                record.setTAUD_ERR_COD(fields[73]);
                record.setTAUD_COD_NOTIFY1(fields[74]);
                record.setTAUD_COD_NOTIFY2(fields[75]);
                record.setTAUD_ERR_VAR_1(fields[76]);
                record.setTAUD_ERR_VAR_2(fields[77]);
                record.setTAUD_NFT_1_VAR_1(fields[78]);
                record.setTAUD_NFT_1_VAR_2(fields[79]);
                record.setTAUD_NFT_2_VAR_1(fields[80]);
                record.setTAUD_NFT_2_VAR_2(fields[81]);
                record.setTAUD_AMT_DISPENSER(Double.parseDouble(fields[82]));
                record.setTAUD_LCL_EJOU(fields[83]);
                record.setTAUD_TYP_OUTPUT(fields[84]);
                record.setTAUD_DES_OUT_CPY(fields[85]);
                record.setTAUD_ARG_SEARCH(fields[86]);
                record.setTAUD_DESTINATIONS(fields[87]);
                record.setTAUD_FLG_PEND_AUT(fields[88]);
                record.setTAUD_AMT_PEND_AUT(Double.parseDouble(fields[89]));
                record.setTAUD_CUS_ADDIT_DAT(fields[90]);


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
