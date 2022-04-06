package com.lollipop.candy.test.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lollipop.candy.test.dao.TestMapper;
import com.lollipop.candy.test.domain.DmTestModel;
import com.lollipop.candy.test.domain.TestModel;
import com.lollipop.candy.test.service.TestService;
import com.lollipop.candy.test.util.RandomUtils;
import com.lollipop.candy.test.vo.TestVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("testService")
public class TestServiceImpl extends ServiceImpl<TestMapper, TestModel> implements TestService {
	
	@Override
	public IPage<TestModel> queryPageList(TestVo vo) {
        Page<TestModel> page = new Page<>(vo.getPageNum(), vo.getPageSize());
        return baseMapper.selectPagedList(page, vo);
	}

	@Override
	public List<TestModel> queryList(TestVo vo) {
		Page<TestModel> page = new Page<>(vo.getPageNum(), vo.getPageSize());
		List<TestModel> pageUsers = baseMapper.selectList(page);
		return pageUsers;
	}

	@Override
	public String saveToken(TestVo vo) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, Object> v = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> s = new LinkedHashMap<String, Object>();
		String ALLCHAR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = ALLCHAR.length();
        Random rand = new Random();
        
        int[] rs = RandomUtils.randomArray(46656, 1679616, 20000);
        
        int j=0;
        while(j<20000) {
        	StringBuffer sb = new StringBuffer();
	        boolean[] bool = new boolean[n];
	        int randInt = 0;
	        for(int i = 0; i < 36 ; i++) {
	        	do {
	        		randInt = rand.nextInt(n);
	        	}while(bool[randInt]);
	        	bool[randInt] = true;
	        	sb.append(ALLCHAR.charAt(randInt));
//	        	System.out.println(randInt);
	        }
	        System.out.println(sb.toString());
	        String token = sb.toString();
	        if(v.get(token) != null) {
	        	continue;
	        }
	        int px = rs[j];
			char[] b = token.toCharArray();
			String salt= intToHex(px, b);
			if(s.get(salt) != null) {
	        	continue;
	        }
			v.put(token, j);
			s.put(salt, j);
			DmTestModel m = new DmTestModel();
			m.setDm(token);
			m.setPx(px);
			m.setSalt(salt);
	        baseMapper.saveToken(m);
	        j++;
        }
		return null;
	}
	
    private static String intToHex(int n, char[] b) {
        StringBuilder sb = new StringBuilder();
        String a;
        while(n != 0){
            sb = sb.append(b[n%36]);
            n = n/36;
        }
        a = sb.reverse().toString();
        return a;
    }

	@Override
	public String saveSalt(TestVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
