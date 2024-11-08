package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Artist;
import com.nt.repository.IArtistRepository;
@Service("artistService")
public class ArtistMgmtServiceImpl implements IArtistMgmtService {
	@Autowired
	private  IArtistRepository  artistRepo;

	@Override
	public String registerArtist(Artist artist) {
		System.out.println("InMemory Proxy obj class name::"+artistRepo.getClass());
		//use repo
		Artist  artist1=artistRepo.save(artist);
		return  artist1.getAid()==null? "Artist is not saved (record not inserted)":"Artist is saved (Record inserted)";
	}
	
	@Override
	public boolean checkArtistAvailability(int id) {
		boolean flag=artistRepo.existsById(id);
		return flag;
	}
	
	@Override
	public long showArtistsCount() {
		//USE REPO
				return artistRepo.count();
	}

}
