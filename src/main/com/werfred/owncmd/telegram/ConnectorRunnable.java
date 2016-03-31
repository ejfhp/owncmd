package com.werfred.owncmd.telegram;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ConnectorRunnable implements Runnable {

	private CloseableHttpClient httpclient = HttpClientBuilder.create()
			.setSSLHostnameVerifier(new NoopHostnameVerifier()).setConnectionTimeToLive(20, TimeUnit.SECONDS).build();

	@Override
	public void run() {

	}

	public String getUpdates() throws Exception {
		int lastUpdateId;

		String token = "217402569:AAEarXEiKrWgXrzqnUR3vOgiTPrydVD0sWI";
		String url = "https://api.telegram.org/bot" + token + "/" + "getUpdates";
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = httpclient.execute(httpGet);

		String responseContent = "";
		try {
			System.out.println(response.getStatusLine());
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				BufferedHttpEntity buf = new BufferedHttpEntity(entity);
				responseContent = EntityUtils.toString(buf, "UTF-8");
				Gson gson = new Gson();
				JsonObject jsonArray = gson.fromJson(responseContent, JsonObject.class);
				
				
				System.out.println("EL: " + jsonArray.toString());
//				Iterator<JsonElement> itJ = jsonArray.iterator();
//				while (itJ.hasNext()) {
//					JsonElement element = itJ.next();
//					System.out.println("EL: " + element.toString());
//				}
			}

		} finally {
			response.close();
		}
		return responseContent;
	}

	public void sendResponse(String resp) throws Exception {
		HttpPost httpPost = new HttpPost("http://targethost/login");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("username", "vip"));
		nvps.add(new BasicNameValuePair("password", "secret"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);

		try {
			System.out.println(response2.getStatusLine());
			HttpEntity entity2 = response2.getEntity();
			// do something useful with the response body
			// and ensure it is fully consumed
			EntityUtils.consume(entity2);
		} finally {
			response2.close();
		}
	}

}
