package com.project.SellerSignupService.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SellerSignupService.dao.SellerSignupDao;
import com.project.SellerSignupService.dao.entity.CategoryEntity;
import com.project.SellerSignupService.dao.entity.ItemEntity;
import com.project.SellerSignupService.dao.entity.SellerSignupEntity;
import com.project.SellerSignupService.dao.entity.SubCategoryEntity;
import com.project.SellerSignupService.model.CategoryPojo;
import com.project.SellerSignupService.model.ItemPojo;
import com.project.SellerSignupService.model.SellerSignupPojo;
import com.project.SellerSignupService.model.SubCategoryPojo;

@Service

public class SellerSignupServiceImpl implements SellerSignupService {
	
	static Logger LOG = Logger.getLogger(SellerSignupServiceImpl.class.getClass());
	@Autowired
	SellerSignupDao sellerDao;

	

	@Override
	public SellerSignupPojo addSeller(SellerSignupPojo sellerPojo) {
		LOG.info("entered addseller()");
		SellerSignupEntity SellerSignupEntity = new SellerSignupEntity(sellerPojo.getId(),
				sellerPojo.getUsername(),
				sellerPojo.getPassword(),
				sellerPojo.getCompany(),
				sellerPojo.getBrief(),
				sellerPojo.getGst(),
				sellerPojo.getAddress(),
				sellerPojo.getEmail(),
				sellerPojo.getWebsite(),
				sellerPojo.getContact(), null);
		   
		
		sellerDao.save(SellerSignupEntity);
		LOG.info("Exited addseller()");
		return sellerPojo;

		
	}
	@Override
    public SellerSignupPojo validateSellerSignup(SellerSignupPojo sellerPojo) {
        BasicConfigurator.configure();

        SellerSignupEntity sellerEntity = sellerDao.findByUsernameAndPassword(sellerPojo.getUsername(),
                sellerPojo.getPassword());
      /*  System.out.println(sellerEntity);

        if (sellerEntity != null) {
            Set<ItemEntity> allItemsEntity = sellerEntity.getAllItems();
            Set<ItemPojo> allItems = new HashSet<ItemPojo>();

            for (ItemEntity itemEntity : allItemsEntity) {
                SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
                CategoryEntity categoryEntity = subCategoryEntity.getCategory();

                CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getId(),
						categoryEntity.getName(), 
						categoryEntity.getBrief());

SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getId(),
	                           subCategoryEntity.getName(),
	                           categoryPojo,
	                           subCategoryEntity.getBrief(),
	                           subCategoryEntity.getGstPercent());

ItemPojo itemPojo = new ItemPojo(itemEntity.getId(), 
				itemEntity.getName(),
				null,
				subCategoryPojo, 
				itemEntity.getPrice(), 
				itemEntity.getDescription(),
				itemEntity.getStock(), 
				itemEntity.getRemarks(),
				itemEntity.getImage()
	  
	  );
            allItems.add(itemPojo);
            }*/
            SellerSignupPojo sellerSignupPojo=new SellerSignupPojo(sellerEntity.getId(),
					sellerEntity.getUsername(),
					sellerEntity.getPassword(),
					sellerEntity.getCompany(),
					sellerEntity.getBrief(),
					sellerEntity.getGst(),
					sellerEntity.getAddress(),
					sellerEntity.getEmail(),
					sellerEntity.getWebsite(),
					sellerEntity.getContact(), null);
        //}
        return sellerSignupPojo;
    }
}
