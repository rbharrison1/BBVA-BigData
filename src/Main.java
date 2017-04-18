import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.*;
import java.util.*;

import static com.mongodb.client.model.Filters.eq;

public class Main {

    public static void main(String[] args) {

        QADTAUDInsert();
        //QADTFDCInsert();

    }

    private static void QADTAUDInsert() {
        String line;
        String[] fields;
        List<Document> list = new ArrayList<>();
        QADTAUD record;
        int i;

        ObjectMapper mapper = new ObjectMapper();

        MongoClient client = new MongoClient("BBVA-bigdata.eil-server.cba.ua.edu", 27017);

        MongoDatabase db = client.getDatabase("AuditTrail");

        MongoCollection myColl = db.getCollection("QADTAUD");

        MongoCollection fdc = db.getCollection("QADTFDC");

        //Console c = System.console();
        //System.out.print("File path: ");
        //String path = c.readLine();
        String path = "C:\\Users\\rharrison15\\Desktop\\Test Files\\FTD.AUDXMIT.QA.161208.1";

        try {

            FileReader fr = new FileReader(path);

            Scanner sc = new Scanner(fr);

            i = 0;
            record = new QADTAUD();

            while(sc.hasNextLine()) {
                line = sc.nextLine();
                fields = line.split("[|]",146);

                try {
                    record = LineToQADTAUD(record, fields, fdc);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    //System.out.println(line);
                }

                try
                {
                    if (record.getTAUD_URN().trim() != null)
                    {
                        OutputStream out = new ByteArrayOutputStream();
                        mapper.writeValue(out, record);

                        String JsonString = out.toString();

                        list.add(Document.parse(JsonString));
                        i++;
                    }

                    if (i >= 2500 || !sc.hasNextLine())
                    {

                        myColl.insertMany(list);

                        list = new ArrayList<>();

                        i = 0;
                    }
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

        client.close();

    }

    private static void QADTFDCInsert() {
        String line;
        String[] fields = new String[14];
        List<Document> list = new ArrayList<>();
        QADTFDC record;
        int i;

        ObjectMapper mapper = new ObjectMapper();

        MongoClient client = new MongoClient("BBVA-bigdata.eil-server.cba.ua.edu", 27017);

        MongoDatabase db = client.getDatabase("AuditTrail");

        MongoCollection myColl = db.getCollection("QADTFDC");


        //Console c = System.console();
        //System.out.print("File path: ");
        //String path = c.readLine();
        String path = "C:\\Users\\rharrison15\\Desktop\\Test Files\\qadtfdc_edit.report";

        try {

            FileReader fr = new FileReader(path);

            Scanner sc = new Scanner(fr);

            i = 0;
            record = new QADTFDC();

            while(sc.hasNextLine()) {
                line = sc.nextLine();

                //region splitting line into fixed length fields
                fields[0] = line.substring(0,8).replace(" ","");
                fields[1] = line.substring(10,16).replace(" ","");
                fields[2] = line.substring(18,26).replace(" ","");
                fields[3] = line.substring(28,35);
                fields[4] = line.substring(37,57);
                fields[5] = line.substring(59,60).replace(" ","");
                fields[6] = line.substring(66,73).replace(" ","");
                fields[7] = line.substring(75,79).replace(" ","");
                fields[8] = line.substring(81,90).replace(" ","");
                fields[9] = line.substring(92,96).replace(" ","");
                fields[10] = line.substring(98,106).replace(" ","");
                fields[11] = line.substring(108,116).replace(" ","");
                fields[12] = line.substring(118,119).replace(" ","");
                fields[13] = line.substring(127,128).replace(" ","");
                //endregion

                record = LineToQADTFDC(record, fields);
                try
                {
                    OutputStream out = new ByteArrayOutputStream();
                    mapper.writeValue(out, record);

                    String JsonString = out.toString();

                    list.add(Document.parse(JsonString));
                    i++;

                    if (i >= 3000 || !sc.hasNextLine())
                    {

                        myColl.insertMany(list);

                        list = new ArrayList<>();

                        i = 0;
                    }
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

        client.close();

    }

    private static QADTAUD LineToQADTAUD(QADTAUD record, String[] fields, MongoCollection fdc) throws IOException {
        record.setTAUD_ENT(checkNull(fields[1]));
        record.setTAUD_URN(checkNull(fields[2]));
        record.setTAUD_STP_REG(checkNull(fields[3]));
        record.setTAUD_BRN_ACCT(checkNull(fields[4]));
        record.setTAUD_ACCT_NTNM(checkNull(fields[5]));
        record.setTAUD_ACCT_TRM(checkNull(fields[6]));
        record.setTAUD_DAY_ACCT(checkNull(fields[7]));
        record.setTAUD_DAT_ACCT(checkNull(fields[8]));
        record.setTAUD_DAT_OPERATION(checkNull(fields[9]));
        record.setTAUD_BRN_LOCATION(checkNull(fields[10]));
        record.setTAUD_NETNAME(checkNull(fields[11]));
        record.setTAUD_TERMINAL(checkNull(fields[12]));
        record.setTAUD_USER_ID(checkNull(fields[13]));
        record.setTAUD_SESSION(checkNull(fields[14]));
        record.setTAUD_TYP_TERMINAL(checkNull(fields[15]));
        record.setTAUD_TERMCODE(checkNull(fields[16]));
        record.setTAUD_DAT_TRMS(checkNull(fields[17]));
        record.setTAUD_TIM_TRMS(checkNull(fields[18]));
        record.setTAUD_CICS(checkNull(fields[19]));
        record.setTAUD_NUM_TASK(Double.parseDouble(fields[20].replace(",", "")));
        record.setTAUD_COD_START(checkNull(fields[21]));
        record.setTAUD_FCC(checkNull(fields[22]));
        record.setTAUD_STATUS(checkNull(fields[23]));
        record.setTAUD_LNG_TERMINAL(checkNull(fields[24]));
        record.setTAUD_COD_APP_1(checkNull(fields[25]));
        record.setTAUD_COD_TRNS_1(checkNull(fields[26]));
        record.setTAUD_COD_PROGRAM_1(checkNull(fields[27]));
        record.setTAUD_PASS_CTRL_2(checkNull(fields[28]));
        record.setTAUD_COD_APP_2(checkNull(fields[29]));
        record.setTAUD_COD_TRNS_2(checkNull(fields[30]));
        record.setTAUD_COD_PROGRAM_2(checkNull(fields[31]));
        record.setTAUD_ST_INP(checkNull(fields[32]));
        record.setTAUD_CASE_A1(checkNull(fields[33]));
        record.setTAUD_DTA_INPUT(checkNull(fields[34]));
        record.setTAUD_DTA_LTH_INP(Double.parseDouble(fields[35].replace(",", "")));
        record.setTAUD_ST_OUT(checkNull(fields[36]));
        record.setTAUD_CASE_A2(checkNull(fields[37]));
        record.setTAUD_DTA_OUTPUT(checkNull(fields[38]));
        record.setTAUD_DTA_LTH_OUT(Double.parseDouble(fields[39].replace(",", "")));
        record.setTAUD_COD_NEXT_TRNS(checkNull(fields[40]));
        record.setTAUD_ACTION(checkNull(fields[41]));
        record.setTAUD_JOB(checkNull(fields[42]));
        record.setTAUD_CASE(checkNull(fields[43]));
        record.setTAUD_DTA(checkNull(fields[44]));
        record.setTAUD_EVENT1(checkNull(fields[45]));
        record.setTAUD_USERAUT1(checkNull(fields[46]));
        record.setTAUD_EVENT2(checkNull(fields[47]));
        record.setTAUD_USERAUT2(checkNull(fields[48]));
        record.setTAUD_EVENT3(checkNull(fields[49]));
        record.setTAUD_USERAUT3(checkNull(fields[50]));
        record.setTAUD_EVENT4(checkNull(fields[51]));
        record.setTAUD_USERAUT4(checkNull(fields[52]));
        record.setTAUD_EVENT5(checkNull(fields[53]));
        record.setTAUD_USERAUT5(checkNull(fields[54]));
        record.setTAUD_EVENT6(checkNull(fields[55]));
        record.setTAUD_USERAUT6(checkNull(fields[56]));
        record.setTAUD_EVENT7(checkNull(fields[57]));
        record.setTAUD_USERAUT7(checkNull(fields[58]));
        record.setTAUD_EVENT8(checkNull(fields[59]));
        record.setTAUD_USERAUT8(checkNull(fields[60]));
        record.setTAUD_EVENT9(checkNull(fields[61]));
        record.setTAUD_USERAUT9(checkNull(fields[62]));
        record.setTAUD_EVENT10(checkNull(fields[63]));
        record.setTAUD_USERAUT10(checkNull(fields[64]));
        record.setTAUD_DES_INP_CPY(checkNull(fields[65]));
        record.setTAUD_INP_PANL(checkNull(fields[66]));
        record.setTAUD_TYP_PROCESS(checkNull(fields[67]));
        record.setTAUD_NUM_SEQUENCE(checkNull(fields[68]));
        record.setTAUD_KEY(checkNull(fields[69]));
        record.setTAUD_ATM(checkNull(fields[70]));
        record.setTAUD_DTA_INP_MOD(checkNull(fields[71]));
        record.setTAUD_TYP_MESSAGE(checkNull(fields[72]));
        record.setTAUD_ERR_COD(checkNull(fields[73]));
        record.setTAUD_COD_NOTIFY1(checkNull(fields[74]));
        record.setTAUD_COD_NOTIFY2(checkNull(fields[75]));
        record.setTAUD_ERR_VAR_1(checkNull(fields[76]));
        record.setTAUD_ERR_VAR_2(checkNull(fields[77]));
        record.setTAUD_NFT_1_VAR_1(checkNull(fields[78]));
        record.setTAUD_NFT_1_VAR_2(checkNull(fields[79]));
        record.setTAUD_NFT_2_VAR_1(checkNull(fields[80]));
        record.setTAUD_NFT_2_VAR_2(checkNull(fields[81]));
        record.setTAUD_AMT_DISPENSER(Double.parseDouble(fields[82].replace(",", "")));
        record.setTAUD_LCL_EJOU(checkNull(fields[83]));
        record.setTAUD_TYP_OUTPUT(checkNull(fields[84]));
        record.setTAUD_DES_OUT_CPY(checkNull(fields[85]));
        record.setTAUD_ARG_SEARCH(checkNull(fields[86]));
        record.setTAUD_DESTINATIONS(checkNull(fields[87]));
        record.setTAUD_FLG_PEND_AUT(checkNull(fields[88]));
        record.setTAUD_AMT_PEND_AUT(Double.parseDouble(fields[89].replace(",", "")));
        record.setTAUD_CUS_ADDIT_DAT(checkNull(fields[90]));
        record.setTAUD_ENT_ANALYTIC(checkNull(fields[91]));
        record.setTAUD_CEN_ANALYTIC(checkNull(fields[92]));
        record.setTAUD_ANL_PROD(checkNull(fields[93]));
        record.setTAUD_CUSTOMER(checkNull(fields[94]));
        record.setTAUD_AMT(Double.parseDouble(fields[95].replace(",", "")));
        record.setTAUD_COD_SPRD(checkNull(fields[96]));
        record.setTAUD_ANL_AIM(checkNull(fields[97]));
        record.setTAUD_ANL_COLT(checkNull(fields[98]));
        record.setTAUD_ANL_SUBCLASSI(checkNull(fields[99]));
        record.setTAUD_TYP_OPE(checkNull(fields[100]));
        record.setTAUD_ACCT_OPE(checkNull(fields[101]));
        record.setTAUD_DTA_APP(checkNull(fields[102]));
        record.setTAUD_CHANNEL(checkNull(fields[103]));
        record.setTAUD_SW_COD_START(checkNull(fields[104]));
        record.setTAUD_SW_LGON_USERI(checkNull(fields[105]));
        record.setTAUD_SW_PREFMT(checkNull(fields[106]));
        record.setTAUD_SW_MGC_ALRM(checkNull(fields[107]));
        record.setTAUD_SW_FLG_CHK_PS(checkNull(fields[108]));
        record.setTAUD_SW_TYP_EXCEPT(checkNull(fields[109]));
        record.setTAUD_FLG_ANL_CHK(checkNull(fields[110]));
        record.setTAUD_NUM_ANL_CHK(Double.parseDouble(fields[111].replace(",", "")));
        record.setTAUD_SW_TYP_CEN(checkNull(fields[112]));
        record.setTAUD_SW_RISK_APPR(checkNull(fields[113]));
        record.setTAUD_NUM_TASK_TIM(Double.parseDouble(fields[114].replace(",", "")));
        record.setTAUD_NUM_APP_TIM_1(Double.parseDouble(fields[115].replace(",", "")));
        record.setTAUD_NUM_APP_TIM_2(Double.parseDouble(fields[116].replace(",", "")));
        record.setTAUD_FLG_EMULATION(checkNull(fields[117]));
        record.setTAUD_NUM_VAL_RUT(Double.parseDouble(fields[118].replace(",", "")));
        record.setTAUD_DEB_CASH(Double.parseDouble(fields[119].replace(",", "")));
        record.setTAUD_DEB_CLEARING(Double.parseDouble(fields[120].replace(",", "")));
        record.setTAUD_AMT_CSHCRE(Double.parseDouble(fields[121].replace(",", "")));
        record.setTAUD_AMT_CLCRE(Double.parseDouble(fields[122].replace(",", "")));
        record.setTAUD_NUM_JOU_REC(Double.parseDouble(fields[123].replace(",", "")));
        record.setTAUD_FLG_UPD_STR(checkNull(fields[124]));
        record.setTAUD_NUM_SEND(Double.parseDouble(fields[125].replace(",", "")));
        record.setTAUD_NUM_CHARACTER(Double.parseDouble(fields[126].replace(",", "")));
        record.setTAUD_NUM_MAP_DOCU(Double.parseDouble(fields[127].replace(",", "")));
        record.setTAUD_NUM_MAP_SCR(Double.parseDouble(fields[128].replace(",", "")));
        record.setTAUD_NUM_STD_MAP(Double.parseDouble(fields[129].replace(",", "")));
        record.setTAUD_NUM_NOSTD_MAP(Double.parseDouble(fields[130].replace(",", "")));
        record.setTAUD_PREFORMAT_1(checkNull(fields[131]));
        record.setTAUD_PREFORMAT_2(checkNull(fields[132]));
        record.setTAUD_ERR_OBJECT(checkNull(fields[133]));
        record.setTAUD_SQLCODE(Integer.parseInt(fields[134].replace(",", "")));
        record.setTAUD_SQLERRM(checkNull(fields[135]));
        record.setTAUD_EIBFN(checkNull(fields[136]));
        record.setTAUD_EIBRSRCE(checkNull(fields[137]));
        record.setTAUD_EIBRCODE(checkNull(fields[138]));
        record.setTAUD_EIBRESP1(Integer.parseInt(fields[139].replace(",", "")));
        record.setTAUD_EIBRESP2(Integer.parseInt(fields[140].replace(",", "")));
        record.setTAUD_INP_MSG_LTH(Double.parseDouble(fields[141].replace(",", "")));
        //record.setTAUD_INP_MSG(fields[142] + "|" + fields[143] + "|" + fields[144] + "|" + fields[145]);

        List<Document> list = new ArrayList<>();
        List<QADTFDC> fdcFields = new ArrayList<>();

        MongoCursor<Document> cursor = null;
        Document doc = null;

        String sdString = "";


        try {
            //Retreives all records in QADTFDC table in order to map TAUD_INP_MSG
            cursor = fdc.find(eq("tfdc_DES_COPY", record.getTAUD_DES_INP_CPY().replace(" ", ""))).iterator();
        }
        catch (NullPointerException e)
        {
            //e.printStackTrace();
            //System.out.println(record.getTAUD_URN());
        }
        finally
        {
            if (cursor != null) {
                while (cursor.hasNext()) {
                    //Populates list with records from cursor
                    list.add((Document) cursor.next());
                }

                ObjectMapper mapper = new ObjectMapper();

                for (Document x : list) {
                    x.remove("_id");
                    String JsonString = x.toJson();
                    //ObjectMapper converts JSON to Java Object
                    QADTFDC temp = mapper.readValue(JsonString, QADTFDC.class);

                    fdcFields.add(temp);
                }

                //Sorts TAUD_INP_MSG fields in correct order
                Collections.sort(fdcFields, (o1, o2) -> o1.getTFDC_NUM_FLD_ID().compareTo(o2.getTFDC_NUM_FLD_ID()));

                if (fields[145].contains("<SD>")) {
                    sdString = fields[145].substring(fields[145].lastIndexOf("<SD>") + 4).replace("</SD>", "");
                }

                fields[145] = fields[145].split("</ME>",2)[0];

                doc = new Document();
                String fieldName = "";
                //For each QADTFDC field, the TAUD_INP_MSG string is split and mapped
                for (QADTFDC x : fdcFields) {
                    fieldName = x.getTFDC_FLD_TAG().trim();
                    try {
                        doc.append(fieldName, checkNull(fields[145].substring(x.getTFDC_FLD_PST().intValue() - 1, x.getTFDC_FLD_PST().intValue() + x.getTFDC_FLD_LTH().intValue() - 1)));
                    } catch (StringIndexOutOfBoundsException err) {
                        //err.printStackTrace();
                        //System.out.println(record.getTAUD_URN() + " ------------- " + x.getTFDC_DES_COPY() + " " + x.getTFDC_FLD_PST() + " " + x.getTFDC_FLD_LTH());
                        //System.out.println(record.getTAUD_URN());
                        doc.append(fieldName, null);
                    }

                }

                if (!sdString.isEmpty())
                {
                    doc.append("SD", sdString);
                }
            }
        }


        record.setTAUD_INP_MSG(doc);

        return record;
    }

    private static QADTFDC LineToQADTFDC(QADTFDC record, String[] fields) {
        record.setTFDC_DES_COPY(fields[0]);
        record.setTFDC_NUM_FLD_ID(Double.parseDouble(fields[1]));
        record.setTFDC_FLD_PST(Double.parseDouble(fields[2]));
        record.setTFDC_FLD_TAG(checkNull(fields[3]));
        record.setTFDC_DES_FIELD(checkNull(fields[4]));
        record.setTFDC_TYP_FIELD(checkNull(fields[5]));
        record.setTFDC_FLD_LTH(Double.parseDouble(fields[6]));
        record.setTFDC_DEC_DIG(Double.parseDouble(fields[7]));
        record.setTFDC_DELIMITER(checkNull(fields[8]));
        record.setTFDC_REQ_FLD(checkNull(fields[9]));
        record.setTFDC_RUT_VAL(checkNull(fields[10]));
        record.setTFDC_ARG_SEARCH(checkNull(fields[11]));
        record.setTFDC_FLD_ENCRYPT(checkNull(fields[12]));
        record.setTFDC_RESERVED_1(checkNull(fields[13]));

        return record;
    }

    private static String checkNull(String field)    {
        if (field.trim().length() == 0)
        {
            field = null;
        }

        return field;
    }

}
