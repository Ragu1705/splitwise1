package com.splitwise.splitwiseApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitwise.splitwiseApp.entity.Friends;
import com.splitwise.splitwiseApp.repository.FriendsRepository;


@Service
public class FriendsService {

	@Autowired
	FriendsRepository friendsRespository;
	
	public Friends saveFriends(Friends friend) {
		return friendsRespository.save(friend);
	}
	
	public List<String> getAllData() {
		List<String> splitwise = new ArrayList<>();
		List<Friends> All=friendsRespository.findAll();
		List<String> namee = new ArrayList<>();
		namee.addAll(All.stream().map(Friends::getName).collect(Collectors.toList()));
		String[] name=(String[]) namee.toArray();
		List<Long> spendd = new ArrayList<>();
		spendd.addAll(All.stream().map(Friends::getSpend).collect(Collectors.toList()));
		Long[] spend=(Long[]) spendd.toArray();
		long total=0,avg=0,ref=0;
		long[] amount_remain= new long[spend.length];
		for(int i=0;i<spend.length;i++) {
			total+=spend[1];
		}
		avg=total/spend.length;
		for(int j=0;j<spend.length;j++) {
			amount_remain[j]=spend[j]-avg;
		}
		for(int k=0;k<amount_remain.length;k++) {
			if(amount_remain[k]<0) {
				for(int l=0;l<amount_remain.length;l++) {
					if(amount_remain[l]>0) {
						ref=amount_remain[k]+amount_remain[l];
						if(ref>0) {
							splitwise.add(String.format("%s need to give %s a amount of %s", name[k],name[l],(amount_remain[k]*-1)));
							amount_remain[l]=ref;
							amount_remain[k]=0;
						}else if(ref<0) {
							splitwise.add(String.format("%s need to give %s a amount of %s",name[k],name[l],amount_remain[l]));
							amount_remain[l]=0;
							amount_remain[k]=ref;
						}else if(ref==0){
							splitwise.add(String.format("%s need to give %s a amount of %s",name[k],name[l],amount_remain[l]));
							amount_remain[k]=0;
							amount_remain[l]=0;
							break;
						}
					}
					//if the person amount is equal to average the loop will break
					else if(amount_remain[k]==0) {
						break;
					}
					//the below code is to run the loop continuously
					else if(l>=amount_remain.length) {
						l=0;
					}
				}
			}
			//the below code is to run the loop continuously
			else if(k>=amount_remain.length) {
				k=0;
			}
		}
		
		return splitwise;
	
	}
	
	
}
