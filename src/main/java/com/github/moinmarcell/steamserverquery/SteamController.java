package com.github.moinmarcell.steamserverquery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/steam")
public class SteamController {

	private final SteamService steamService;

	public SteamController(SteamService steamService) {
		this.steamService = steamService;
	}

	@GetMapping("/server")
	public Map<String, Object> getServerInfo(
			@RequestParam String ip,
			@RequestParam int port
	) {
		return steamService.queryServer(ip, port);
	}
}
