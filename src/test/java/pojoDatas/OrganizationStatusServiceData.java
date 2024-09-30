package pojoDatas;

import io.cucumber.java.hu.Ha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//[
//        {
//        "id": 1,
//        "name": "Active",
//        "description": "Organization account is activated and allowed to use the application"
//        },
//        {
//        "id": 3,
//        "name": "Passive",
//        "description": "Organization account is deactivated, and not allowed to use the application"
//        },
//        {
//        "id": 2,
//        "name": "Pending Confirmation",
//        "description": "Organization account is created, and waiting confirmation to use the application"
//        }
//        ]

public class OrganizationStatusServiceData {

    public List<Map<String, Object>> expectedDataList= new ArrayList<>();


    public List<Map<String, Object>> setUpTestData(){


        HashMap<String, Object> expectedDataStatusCode= new HashMap<>();
//        expectedDataStatusCode.put("StatusCode", 200);

//        List<String> expected = new ArrayList<>();
//        expectedData1.add("1");
//        expectedData1.add("Active");
//        expectedData1.add("Organization account is activated and allowed to use the application");
//        HashMap<String, Object> expectedDataids= new HashMap<>();
//       expectedDataids.put("data1", expectedDataid1);



        List<String> expectedDataname = new ArrayList<>();
        expectedDataname.add("Active");
        expectedDataname.add("Passive");
        expectedDataname.add("Pending Confirmation");

        HashMap<String, Object> expectedDataMapNames= new HashMap<>();
        expectedDataMapNames.put("name",expectedDataname);


        List<String> expectedDatadescription = new ArrayList<>();
        expectedDatadescription.add("Organization account is activated and allowed to use the application");
        expectedDatadescription.add("Organization account is deactivated, and not allowed to use the application");
        expectedDatadescription.add("Organization account is created, and waiting confirmation to use the application");


        HashMap<String, Object> expectedDatadescriptions= new HashMap<>();
        expectedDatadescriptions.put("description",expectedDatadescription);


//        expectedDataList.add(expectedDataStatusCode);
//        expectedDataList.add(expectedDataids);
        expectedDataList.add(expectedDataMapNames);
        expectedDataList.add(expectedDatadescriptions);




        return expectedDataList;

    }
    public HashMap<String,Object>setUpData(int id,String name,String description){

        HashMap<String,Object> expectedBodyData=new HashMap<>();
//        expectedBodyData.put("status",status);
//        expectedBodyData.put("id",id);
        expectedBodyData.put("name",name);
        expectedBodyData.put("description",description);


        return expectedBodyData;

    }


}
