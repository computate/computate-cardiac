package com.heytate.frFR.cardiac.servlet.cdi.example;

import io.swagger.annotations.Api;

@Api("/harvester")
public class ArtHarvesterImpl implements ArtHarvester {

	@Override
	public String get() {
		return "";
	}

}
