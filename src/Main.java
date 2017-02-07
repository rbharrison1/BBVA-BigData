import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String line;
        String[] fields;
        List<QADTAUD> list = new ArrayList<>();
        QADTAUD record;
        String JsonString;

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

                record = new QADTAUD();

                //************************************************************
                // ASSIGN EACH FIELD TO CORRESPONDING MEMBER IN QADTAUD OBJECT
                // ADD OBJECT TO LIST
                //************************************************************

                //1-30 start with TAUD_ENT (Lauryn)
                record.setTAUD_ENT(fields[1]);
                record.setTAUD_URN(fields[2]);
                record.setTAUD_STP_REG(fields[3]);
                record.setTAUD_BRN_ACCT(fields[4]);
                record.setTAUD_ACCT_NTNM(fields[5]);
                record.setTAUD_ACCT_TRM(fields[6]);
                record.setTAUD_DAY_ACCT(fields[7]);
                record.setTAUD_DAT_ACCT(fields[8]);
                record.setTAUD_DAT_OPERATION(fields[9]);
                record.setTAUD_BRN_LOCATION(fields[10]);
                record.setTAUD_NETNAME(fields[11]);
                record.setTAUD_TERMINAL(fields[12]);
                record.setTAUD_USER_ID(fields[13]);
                record.setTAUD_SESSION(fields[14]);
                record.setTAUD_TYP_TERMINAL(fields[15]);
                record.setTAUD_TERMCODE(fields[16]);
                record.setTAUD_DAT_TRMS(fields[17]);
                record.setTAUD_TIM_TRMS(fields[18]);
                record.setTAUD_CICS(fields[19]);
                record.setTAUD_NUM_TASK(Double.parseDouble(fields[20]));
                record.setTAUD_COD_START(fields[21]);
                record.setTAUD_FCC(fields[22]);
                record.setTAUD_STATUS(fields[23]);
                record.setTAUD_LNG_TERMINAL(fields[24]);
                record.setTAUD_COD_APP_1(fields[25]);
                record.setTAUD_COD_TRNS_2(fields[26]);
                record.setTAUD_COD_PROGRAM_1(fields[27]);
                record.setTAUD_PASS_CTRL_2(fields[28]);
                record.setTAUD_COD_APP_2(fields[29]);
                record.setTAUD_COD_TRNS_2(fields[30]);



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
                record.setTAUD_ENT_ANALYTIC(fields[91]);
                record.setTAUD_CEN_ANALYTIC(fields[92]);
                record.setTAUD_ANL_PROD(fields[93]);
                record.setTAUD_CUSTOMER(fields[94]);
                record.setTAUD_AMT(Double.parseDouble(fields[95]));
                record.setTAUD_COD_SPRD(fields[96]);
                record.setTAUD_ANL_AIM(fields[97]);
                record.setTAUD_ANL_COLT(fields[98]);
                record.setTAUD_ANL_SUBCLASSI(fields[99]);
                record.setTAUD_TYP_OPE(fields[100]);
                record.setTAUD_ACCT_OPE(fields[101]);
                record.setTAUD_DTA_APP(fields[102]);
                record.setTAUD_CHANNEL(fields[103]);
                record.setTAUD_SW_COD_START(fields[104]);
                record.setTAUD_SW_LGON_USERI(fields[105]);
                record.setTAUD_SW_PREFMT(fields[106]);
                record.setTAUD_SW_MGC_ALRM(fields[107]);
                record.setTAUD_SW_FLG_CHK_PS(fields[108]);
                record.setTAUD_SW_TYP_EXCEPT(fields[109]);
                record.setTAUD_FLG_ANL_CHK(fields[110]);
                record.setTAUD_NUM_ANL_CHK(Double.parseDouble(fields[111]));
                record.setTAUD_SW_TYP_CEN(fields[112]);
                record.setTAUD_SW_RISK_APPR(fields[113]);
                record.setTAUD_NUM_TASK_TIM(Double.parseDouble(fields[114]));
                record.setTAUD_NUM_APP_TIM_1(Double.parseDouble(fields[115]));
                record.setTAUD_NUM_APP_TIM_2(Double.parseDouble(fields[116]));
                record.setTAUD_FLG_EMULATION(fields[117]);
                record.setTAUD_NUM_VAL_RUT(Double.parseDouble(fields[118]));
                record.setTAUD_DEB_CASH(Double.parseDouble(fields[119]));
                record.setTAUD_DEB_CLEARING(Double.parseDouble(fields[120]));

                //121-142 start with TAUD_AMT_CSHCRE (Ryne)
                record.setTAUD_AMT_CSHCRE(Double.parseDouble(fields[121]));
                record.setTAUD_AMT_CLCRE(Double.parseDouble(fields[122]));
                record.setTAUD_NUM_JOU_REC(Double.parseDouble(fields[123]));
                record.setTAUD_FLG_UPD_STR(fields[124]);
                record.setTAUD_NUM_SEND(Double.parseDouble(fields[125]));
                record.setTAUD_NUM_CHARACTER(Double.parseDouble(fields[126]));
                record.setTAUD_NUM_MAP_DOCU(Double.parseDouble(fields[127]));
                record.setTAUD_NUM_MAP_SCR(Double.parseDouble(fields[128]));
                record.setTAUD_NUM_STD_MAP(Double.parseDouble(fields[129]));
                record.setTAUD_NUM_NOSTD_MAP(Double.parseDouble(fields[130]));
                record.setTAUD_PREFORMAT_1(fields[131]);
                record.setTAUD_PREFORMAT_2(fields[132]);
                record.setTAUD_ERR_OBJECT(fields[133]);
                record.setTAUD_SQLCODE(Integer.parseInt(fields[134]));
                record.setTAUD_SQLERRM(fields[135]);
                record.setTAUD_EIBFN(fields[136]);
                record.setTAUD_EIBRSRCE(fields[137]);
                record.setTAUD_EIBRCODE(fields[138]);
                record.setTAUD_EIBRESP1(Integer.parseInt(fields[139]));
                record.setTAUD_EIBRESP2(Integer.parseInt(fields[140]));
                record.setTAUD_INP_MSG_LTH(Double.parseDouble(fields[141]));
                record.setTAUD_INP_MSG(fields[142]);




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
        final OutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();

        try
        {
            mapper.writeValue(out, list);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        JsonString = out.toString();

        System.out.print(JsonString);


        //******************
        // INSERT TO MONGODB
        //******************




    }
}
