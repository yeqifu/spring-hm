import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: yeqifu
 * @date: 2023/3/13 9:10
 */
public class NumberUtils {
    /**
     * 停车时长向上取整方法
     *
     * @param parkingDuration 停车时长
     * @return 停车时长向上取整的结果
     */
    public static int roundUp(Integer parkingDuration) {
        Float parkingDurationUnit = 60f;
        float temp = parkingDuration / parkingDurationUnit;
        System.out.println("temp = " + temp);
        double ceil = Math.ceil(temp);
        System.out.println("ceil = " + ceil);
        return (int) (ceil * parkingDurationUnit);
    }

    public static void main(String[] args) {
        //System.out.println(NumberUtils.roundUp(210));

        String s = "[{\"chargeRuleId\":\"27\",\"smallImage\":\"http://cloudpark365.oss-cn-hangzhou.aliyuncs.com/temporary-fq/parking_entrance-fq/2131/202303/2131_1891_1680230377000-1.jpg?Expires=1680232213&OSSAccessKeyId=u1KDPtqLl3JkCjno&Signature=yCVDtvi0yhCGig5fIuMntLNmuek%3D\",\"carInType\":\"0\",\"plateNo\":\"浙A00016\",\"carParkId\":\"10002131\",\"carparkName\":\"云停车测试141\",\"bigImage\":\"http://temporary-reformer.oss-cn-hangzhou.aliyuncs.com/temporary-fq/parking_entrance-fq/2131/202303/2131_1891_1680230377000-2.jpg?Expires=1680232213&OSSAccessKeyId=u1KDPtqLl3JkCjno&Signature=lzxDl3eQsC%2B1eMQWxjqRvD6iyVg%3D\",\"inDate\":\"2023-03-31 10:39:40\",\"userName\":\"临时车\",\"type\":\"0\",\"uid\":\"2131_11a0d0bf-35c5-4eb0-8949-19f10edc6629\",\"carColor\":\"1\",\"imagePaths\":\"temporary-fq/parking_entrance-fq/2131/202303/2131_1891_1680230377000\",\"channelId\":\"1891\"}]";
        JSONArray jsonObject = JSONArray.parseArray(s);
        JSONObject o = (JSONObject) jsonObject.get(0);
        System.out.println("o:" + o);
        Object parse = JSONArray.parse(s);
        System.out.println(parse);
        System.out.println(jsonObject);
        System.out.println(JSONObject.toJSONString(jsonObject));
    }
}
