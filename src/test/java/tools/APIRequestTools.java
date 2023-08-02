package tools;

import okhttp3.*;
import org.apache.log4j.Logger;

import java.io.IOException;

public class APIRequestTools {

    Logger logger = Logger.getLogger(APIRequestTools.class);

    private static String TOKEN = "CfDJ8HNo0BxCAp9Aq80wYgjo3a357s2Y32X9UvZmklcpk4AcIOW6LcK7g_BTG2LVCMNxyQtZyRkDqfLcxR8dVLgP7HCfzLKCBUYlu_VrIuPa0dsbhiATo1pl759kOX9upMxeYM68I55O5G9QTaA7HQPc3eA";

    public static Response sendCreateUserRequest(String userName, String email, String password) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "Username=" + userName + "&Email=" + email + "&Password=" + password + "&ConfirmPassword=" + password + "&action=&__RequestVerificationToken=" + TOKEN);
        Request request = new Request.Builder()
                .url("https://easychamp.com/sc-security-api/Account/Register?returnurl=https%3A%2F%2Feasychamp.com%2Fadmin%2Fleagues")
                .method("POST", body)
                .addHeader("authority", "easychamp.com")
                .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .addHeader("accept-language", "en-US,en;q=0.9,ru;q=0.8,zh-CN;q=0.7,zh;q=0.6")
                .addHeader("cache-control", "max-age=0")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cookie", ".AspNetCore.Antiforgery.VyLW6ORzMgk=CfDJ8HNo0BxCAp9Aq80wYgjo3a38gH2Mw0fhAWlB_xt0D8ndIz6MXWhJ7Z6Mbk6Qka0MwE1FJEjiJzHF2dC8RCkhyOGlRwzxzgqEGzlR25eYjFFL1FigNvpexPqMs0KkHmeQr3i-qbnHK597vlBpMaDQ9xw; _gcl_au=1.1.215135096.1684721318; messagesUtk=ccf0e40a60864e859138a637f1d6ebac; hubspotutk=6e23b3c3594c0b63297c70a66bc76bd4; .AspNetCore.Culture=c%3Den%7Cuic%3Den; _ga=GA1.1.1096474770.1684721317; __stripe_mid=d756b5e7-f7e4-4a42-9c6c-dbbf83cc2d64e9a0c3; __hssrc=1; __hstc=211132874.6e23b3c3594c0b63297c70a66bc76bd4.1684721319182.1687842873443.1688793313202.4; __stripe_sid=80cfe826-b766-447a-83f2-8bb6424d754b51c2b7; __hssc=211132874.10.1688793313202; _ga_0640MS27ZG=GS1.1.1688793310.6.1.1688795904.60.0.0; _ga_0Z6CY5ECVC=GS1.1.1688793311.5.1.1688795904.60.0.0")
                .addHeader("origin", "https://easychamp.com")
                .addHeader("referer", "https://easychamp.com/sc-security-api/Account/Register?returnurl=https%3A%2F%2Feasychamp.com%2Fadmin%2Fleagues")
                .addHeader("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"macOS\"")
                .addHeader("sec-fetch-dest", "document")
                .addHeader("sec-fetch-mode", "navigate")
                .addHeader("sec-fetch-site", "same-origin")
                .addHeader("sec-fetch-user", "?1")
                .addHeader("upgrade-insecure-requests", "1")
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                .build();

        return client.newCall(request).execute();
    }
}
