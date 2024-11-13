package com.malay.dao;

import com.malay.model.Member;

public interface MemberDAO {
	void addMember(Member m);
	void updateMember(Member m);
	void deleteMember(String username);
	Member viewMember(String username,String password);
	Member view(String username);
}
