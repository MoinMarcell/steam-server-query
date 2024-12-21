package com.github.moinmarcell.steamserverquery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class SteamService {

	private final RestClient restClient;
	private static final String BASE_URL = "https://api.steampowered.com";

	@Value("${steam.api.key}")
	private String apiKey;

	public SteamService(RestClient.Builder builder) {
		this.restClient = builder.baseUrl(BASE_URL).build();
	}

	public Map<String, Object> queryServer(String ip, int port) {
		String params = "addr=" + ip + ":" + port + "&key=" + apiKey;
		return restClient.get()
				.uri("/ISteamApps/GetServersAtAddress/v1?" + params)
				.headers(httpHeaders -> httpHeaders.set("Content-Type", "application/x-www-form-urlencoded"))
				.retrieve()
				.body(new ParameterizedTypeReference<>() {
				});
	}
}
