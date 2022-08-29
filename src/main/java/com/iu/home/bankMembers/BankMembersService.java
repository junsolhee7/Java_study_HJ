package com.iu.home.bankMembers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.bankAccount.BankAccountDAO;
import com.iu.home.bankAccount.BankAccountDTO;
import com.iu.home.util.FileManager;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired FileManager fileManager;
//	@Autowired
//	private ServletContext servletContext;
	
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
//	
//	public Map<String,Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		map.put("list",ar);
//		map.put("dto", bankMembersDTO);
//		
//		return map;
//	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO,MultipartFile photo,ServletContext servletContext)throws Exception{
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		String path = "resources/upload/member";
		String fileName = fileManager.saveFile(servletContext,path, photo);
		
			if(!photo.isEmpty()) {
			
				BankMembersFileDTO membersFileDTO = new BankMembersFileDTO();
				membersFileDTO.setFileName(fileName);
				membersFileDTO.setOriName(photo.getOriginalFilename());
				membersFileDTO.setUserName(bankMembersDTO.getUserName());
				bankMembersDAO.setAddFile(membersFileDTO);
				

			}
			
		
		//2.저장된 파일정보를 DB에 저장
//		BankMembersFileDTO membersFileDTO = new BankMembersFileDTO();
//		membersFileDTO.setFileName(fileName);
//		membersFileDTO.setOriName(photo.getOriginalFilename());
//		membersFileDTO.setUserName(bankMembersDTO.getUserName());
//		
//		bankMembersDAO.setAddFile(membersFileDTO);
//		
//		}//isEmpty 끝
//
//		int result = bankMembersDAO.setJoin(bankMembersDTO);
		return result;
	}
	
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		
		return bankMembersDAO.getLogin(bankMembersDTO);
	}

	
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankMembersDAO.getSearchByID(search);
	}
	


}
