package com.nt.service;

import com.nt.entity.Artist;

public interface IArtistMgmtService {
	public String registerArtist(Artist artist);

	public boolean checkArtistAvailability(int id);

	public long showArtistsCount();
}
