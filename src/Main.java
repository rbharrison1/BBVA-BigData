import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.util.JSON;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
////region QADTAUD
//        String line;
//        String[] fields;
//        List<QADTAUD> list = new ArrayList<>();
//        QADTAUD record;
//
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        MongoClient client = new MongoClient("BBVA-bigdata.eil-server.cba.ua.edu", 27017);
//
//        DB db = client.getDB("AuditTrailTest");
//
//        DBCollection myColl = db.getCollection("RecordsTAUD");
//
//        //*************
//        // READ IN FILE
//        //*************
//
//        //Console c = System.console();
//        //System.out.print("File path: ");
//        //String path = c.readLine();
//        String path = "C:\\Users\\dlocke15\\Desktop\\BBVA Text Files\\ZIP 3\\FTD.AUDXMIT.QA.161228.1";
//
//        try {
//
//            FileReader fr = new FileReader(path);
//
//            //BufferedReader br = new BufferedReader(fr);
//            Scanner sc = new Scanner(fr);
//
//
//
//            //*********************
//            // SPLIT FILE BY RECORD
//            //*********************
//            while(sc.hasNextLine()) {
//                //***************************
//                // SPLIT EACH RECORD BY FIELD
//                //***************************
//                line = sc.nextLine();
//                fields = line.split("[|]");
//
//                record = new QADTAUD();
//
//                //************************************************************
//                // ASSIGN EACH FIELD TO CORRESPONDING MEMBER IN QADTAUD OBJECT
//                // ADD OBJECT TO LIST
//                //************************************************************
//
//                if (fields.length > 100) {
//                    //1-30 start with TAUD_ENT (Lauryn)
//                    record.setTAUD_ENT(fields[1]);
//                    record.setTAUD_URN(fields[2]);
//                    record.setTAUD_STP_REG(fields[3]);
//                    record.setTAUD_BRN_ACCT(fields[4]);
//                    record.setTAUD_ACCT_NTNM(fields[5]);
//                    record.setTAUD_ACCT_TRM(fields[6]);
//                    record.setTAUD_DAY_ACCT(fields[7]);
//                    record.setTAUD_DAT_ACCT(fields[8]);
//                    record.setTAUD_DAT_OPERATION(fields[9]);
//                    record.setTAUD_BRN_LOCATION(fields[10]);
//                    record.setTAUD_NETNAME(fields[11]);
//                    record.setTAUD_TERMINAL(fields[12]);
//                    record.setTAUD_USER_ID(fields[13]);
//                    record.setTAUD_SESSION(fields[14]);
//                    record.setTAUD_TYP_TERMINAL(fields[15]);
//                    record.setTAUD_TERMCODE(fields[16]);
//                    record.setTAUD_DAT_TRMS(fields[17]);
//                    record.setTAUD_TIM_TRMS(fields[18]);
//                    record.setTAUD_CICS(fields[19]);
//                    record.setTAUD_NUM_TASK(Double.parseDouble(fields[20].replace(",", "")));
//                    record.setTAUD_COD_START(fields[21]);
//                    record.setTAUD_FCC(fields[22]);
//                    record.setTAUD_STATUS(fields[23]);
//                    record.setTAUD_LNG_TERMINAL(fields[24]);
//                    record.setTAUD_COD_APP_1(fields[25]);
//                    record.setTAUD_COD_TRNS_1(fields[26]);
//                    record.setTAUD_COD_PROGRAM_1(fields[27]);
//                    record.setTAUD_PASS_CTRL_2(fields[28]);
//                    record.setTAUD_COD_APP_2(fields[29]);
//                    record.setTAUD_COD_TRNS_2(fields[30]);
//
//
//                    //31-60 start with TAUD_COD_PROGRAM_2 (Danella)
//                    record.setTAUD_COD_PROGRAM_2(fields[31]);
//                    record.setTAUD_ST_INP(fields[32]);
//                    record.setTAUD_CASE_A1(fields[33]);
//                    record.setTAUD_DTA_INPUT(fields[34]);
//                    record.setTAUD_DTA_LTH_INP(Double.parseDouble(fields[35].replace(",", "")));
//                    record.setTAUD_ST_OUT(fields[36]);
//                    record.setTAUD_CASE_A2(fields[37]);
//                    record.setTAUD_DTA_OUTPUT(fields[38]);
//                    record.setTAUD_DTA_LTH_OUT(Double.parseDouble(fields[39].replace(",", "")));
//                    record.setTAUD_COD_NEXT_TRNS(fields[40]);
//                    record.setTAUD_ACTION(fields[41]);
//                    record.setTAUD_JOB(fields[42]);
//                    record.setTAUD_CASE(fields[43]);
//                    record.setTAUD_DTA(fields[44]);
//                    record.setTAUD_EVENT1(fields[45]);
//                    record.setTAUD_USERAUT1(fields[46]);
//                    record.setTAUD_EVENT2(fields[47]);
//                    record.setTAUD_USERAUT2(fields[48]);
//                    record.setTAUD_EVENT3(fields[49]);
//                    record.setTAUD_USERAUT3(fields[50]);
//                    record.setTAUD_EVENT4(fields[51]);
//                    record.setTAUD_USERAUT4(fields[52]);
//                    record.setTAUD_EVENT5(fields[53]);
//                    record.setTAUD_USERAUT5(fields[54]);
//                    record.setTAUD_EVENT6(fields[55]);
//                    record.setTAUD_USERAUT6(fields[56]);
//                    record.setTAUD_EVENT7(fields[57]);
//                    record.setTAUD_USERAUT7(fields[58]);
//                    record.setTAUD_EVENT8(fields[59]);
//                    record.setTAUD_USERAUT8(fields[60]);
//
//                    //61-90 started with TAUD_EVENT9 (Dallas)
//                    record.setTAUD_EVENT9(fields[61]);
//                    record.setTAUD_USERAUT9(fields[62]);
//                    record.setTAUD_EVENT10(fields[63]);
//                    record.setTAUD_USERAUT10(fields[64]);
//                    record.setTAUD_DES_INP_CPY(fields[65]);
//                    record.setTAUD_INP_PANL(fields[66]);
//                    record.setTAUD_TYP_PROCESS(fields[67]);
//                    record.setTAUD_NUM_SEQUENCE(fields[68]);
//                    record.setTAUD_KEY(fields[69]);
//                    record.setTAUD_ATM(fields[70]);
//                    record.setTAUD_DTA_INP_MOD(fields[71]);
//                    record.setTAUD_TYP_MESSAGE(fields[72]);
//                    record.setTAUD_ERR_COD(fields[73]);
//                    record.setTAUD_COD_NOTIFY1(fields[74]);
//                    record.setTAUD_COD_NOTIFY2(fields[75]);
//                    record.setTAUD_ERR_VAR_1(fields[76]);
//                    record.setTAUD_ERR_VAR_2(fields[77]);
//                    record.setTAUD_NFT_1_VAR_1(fields[78]);
//                    record.setTAUD_NFT_1_VAR_2(fields[79]);
//                    record.setTAUD_NFT_2_VAR_1(fields[80]);
//                    record.setTAUD_NFT_2_VAR_2(fields[81]);
//                    record.setTAUD_AMT_DISPENSER(Double.parseDouble(fields[82].replace(",", "")));
//                    record.setTAUD_LCL_EJOU(fields[83]);
//                    record.setTAUD_TYP_OUTPUT(fields[84]);
//                    record.setTAUD_DES_OUT_CPY(fields[85]);
//                    record.setTAUD_ARG_SEARCH(fields[86]);
//                    record.setTAUD_DESTINATIONS(fields[87]);
//                    record.setTAUD_FLG_PEND_AUT(fields[88]);
//                    record.setTAUD_AMT_PEND_AUT(Double.parseDouble(fields[89].replace(",", "")));
//                    record.setTAUD_CUS_ADDIT_DAT(fields[90]);
//
//
//                    //91-120 start with TAUD_ENT_ANALYTIC (Taylor)
//                    record.setTAUD_ENT_ANALYTIC(fields[91]);
//                    record.setTAUD_CEN_ANALYTIC(fields[92]);
//                    record.setTAUD_ANL_PROD(fields[93]);
//                    record.setTAUD_CUSTOMER(fields[94]);
//                    record.setTAUD_AMT(Double.parseDouble(fields[95].replace(",", "")));
//                    record.setTAUD_COD_SPRD(fields[96]);
//                    record.setTAUD_ANL_AIM(fields[97]);
//                    record.setTAUD_ANL_COLT(fields[98]);
//                    record.setTAUD_ANL_SUBCLASSI(fields[99]);
//                    record.setTAUD_TYP_OPE(fields[100]);
//                    record.setTAUD_ACCT_OPE(fields[101]);
//                    record.setTAUD_DTA_APP(fields[102]);
//                    record.setTAUD_CHANNEL(fields[103]);
//                    record.setTAUD_SW_COD_START(fields[104]);
//                    record.setTAUD_SW_LGON_USERI(fields[105]);
//                    record.setTAUD_SW_PREFMT(fields[106]);
//                    record.setTAUD_SW_MGC_ALRM(fields[107]);
//                    record.setTAUD_SW_FLG_CHK_PS(fields[108]);
//                    record.setTAUD_SW_TYP_EXCEPT(fields[109]);
//                    record.setTAUD_FLG_ANL_CHK(fields[110]);
//                    record.setTAUD_NUM_ANL_CHK(Double.parseDouble(fields[111].replace(",", "")));
//                    record.setTAUD_SW_TYP_CEN(fields[112]);
//                    record.setTAUD_SW_RISK_APPR(fields[113]);
//                    record.setTAUD_NUM_TASK_TIM(Double.parseDouble(fields[114].replace(",", "")));
//                    record.setTAUD_NUM_APP_TIM_1(Double.parseDouble(fields[115].replace(",", "")));
//                    record.setTAUD_NUM_APP_TIM_2(Double.parseDouble(fields[116].replace(",", "")));
//                    record.setTAUD_FLG_EMULATION(fields[117]);
//                    record.setTAUD_NUM_VAL_RUT(Double.parseDouble(fields[118].replace(",", "")));
//                    record.setTAUD_DEB_CASH(Double.parseDouble(fields[119].replace(",", "")));
//                    record.setTAUD_DEB_CLEARING(Double.parseDouble(fields[120].replace(",", "")));
//
//                    //121-142 start with TAUD_AMT_CSHCRE (Ryne)
//                    record.setTAUD_AMT_CSHCRE(Double.parseDouble(fields[121].replace(",", "")));
//                    record.setTAUD_AMT_CLCRE(Double.parseDouble(fields[122].replace(",", "")));
//                    record.setTAUD_NUM_JOU_REC(Double.parseDouble(fields[123].replace(",", "")));
//                    record.setTAUD_FLG_UPD_STR(fields[124]);
//                    record.setTAUD_NUM_SEND(Double.parseDouble(fields[125].replace(",", "")));
//                    record.setTAUD_NUM_CHARACTER(Double.parseDouble(fields[126].replace(",", "")));
//                    record.setTAUD_NUM_MAP_DOCU(Double.parseDouble(fields[127].replace(",", "")));
//                    record.setTAUD_NUM_MAP_SCR(Double.parseDouble(fields[128].replace(",", "")));
//                    record.setTAUD_NUM_STD_MAP(Double.parseDouble(fields[129].replace(",", "")));
//                    record.setTAUD_NUM_NOSTD_MAP(Double.parseDouble(fields[130].replace(",", "")));
//                    record.setTAUD_PREFORMAT_1(fields[131]);
//                    record.setTAUD_PREFORMAT_2(fields[132]);
//                    record.setTAUD_ERR_OBJECT(fields[133]);
//                    record.setTAUD_SQLCODE(Integer.parseInt(fields[134].replace(",", "")));
//                    record.setTAUD_SQLERRM(fields[135]);
//                    record.setTAUD_EIBFN(fields[136]);
//                    record.setTAUD_EIBRSRCE(fields[137]);
//                    record.setTAUD_EIBRCODE(fields[138]);
//                    record.setTAUD_EIBRESP1(Integer.parseInt(fields[139].replace(",", "")));
//                    record.setTAUD_EIBRESP2(Integer.parseInt(fields[140].replace(",", "")));
//                    record.setTAUD_INP_MSG_LTH(Double.parseDouble(fields[141].replace(",", "")));
//                    record.setTAUD_INP_MSG(fields[142]);
//                }
//                try
//                {
//                    OutputStream out = new ByteArrayOutputStream();
//                    mapper.writeValue(out, record);
//
//
//                    String JsonString = out.toString();
//
//                    myColl.insert((DBObject) JSON.parse(JsonString));
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                //list.add(record);
//
//            }
//            if (sc.ioException() != null) {
//                throw sc.ioException();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //*********************************
//        // CONVERT FROM JAVA OBJECT TO JSON
//        //*********************************
//
//
//
//        /*
//        //writing to file
//        try (FileWriter file = new FileWriter("C:/Users/rharrison15/Desktop/output.json")){
//            file.write(JsonString);
//            System.out.println("Successfully written to file.");
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        */
//
//
//        //******************
//        // INSERT TO MONGODB
//        //******************
//
//
//        client.close();
////endregion
//region QADTFDC
        String line1;
        String[] fields1;
        List<QADTFDC> list1 = new ArrayList<>();
        QADTFDC record1;


        ObjectMapper mapper1 = new ObjectMapper();

        MongoClient client1 = new MongoClient("BBVA-bigdata.eil-server.cba.ua.edu", 27017);

        DB db1 = client1.getDB("InputLayout");

        DBCollection myColl1 = db1.getCollection("RecordsTFDC");

        //*************
        // READ IN FILE
        //*************

        String path1 = "C:\\Users\\dlocke15\\Desktop\\BBVA Text Files\\ZIP 1\\qadtfdc.report";

        try {

            FileReader fr = new FileReader(path1);

            Scanner sc = new Scanner(fr);

            //*********************
            // SPLIT FILE BY RECORD
            //*********************

            while(sc.hasNextLine()) {

                //***************************
                // SPLIT EACH RECORD BY FIELD
                //***************************

                line1 = sc.nextLine();
                fields1 = line1.split("[|]");
                record1 = new QADTFDC();

                //************************************************************
                // ASSIGN EACH FIELD TO CORRESPONDING MEMBER IN QADTAUD OBJECT
                // ADD OBJECT TO LIST
                //************************************************************

                if (fields1.length > 100) {
                    record1.setTFDC_DES_COPY(fields1[1]);
                    record1.setTFDC_NUM_FLD_ID(Double.parseDouble(fields1[2].replace(",", "")));
                    record1.setTFDC_FLD_PST(Double.parseDouble(fields1[3].replace(",", "")));
                    record1.setTFDC_FLD_TAG(fields1[4]);
                    record1.setTFDC_DES_FIELD(fields1[5]);
                    record1.setTFDC_TYP_FIELD(fields1[6]);
                    record1.setTFDC_FLD_LTH(Double.parseDouble(fields1[7].replace(",", "")));
                    record1.setTFDC_DEC_DIG(Double.parseDouble(fields1[8].replace(",", "")));
                    record1.setTFDC_DELIMITER(fields1[9]);
                    record1.setTFDC_REQ_FLD(fields1[10]);
                    record1.setTFDC_RUT_VAL(fields1[11]);
                    record1.setTFDC_ARG_SEARCH(fields1[12]);
                    record1.setTFDC_FLD_ENCRYPT(fields1[13]);
                    record1.setTFDC_RESERVED_1(fields1[14]);
                }
                try
                {
                    OutputStream out = new ByteArrayOutputStream();
                    mapper1.writeValue(out, record1);


                    String JsonString = out.toString();

                    myColl1.insert((DBObject) JSON.parse(JsonString));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                //list.add(record);

            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //*********************************
        // CONVERT FROM JAVA OBJECT TO JSON
        //*********************************

        //******************
        // INSERT TO MONGODB
        //******************
        client1.close();
//endregion
    }


}
