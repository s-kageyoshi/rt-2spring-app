package jp.co.sss.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanManager;

/**
 * ITパスポート所持状況検索クラス
 * 従業員ID昇順で表示。
 */
@Service
public class SearchForEmployeesByItPassService {
	
	@Autowired
	EmployeeRepository repository;
	
	public List<EmployeeBean> execute(Integer eplItPass){
		List<Employee> empItPass = repository.findByItPassOrderByEmpId(eplItPass);
		return BeanManager.copyEntityListToBeanList(empItPass);
	}

}
