package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.Purchase;
import com.sha.springbootproductseller.repository.PurchaseRepository;
import com.sha.springbootproductseller.repository.projection.PurchaseItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService{
    private final PurchaseRepository purchaseRepository;

    @Override
    public Purchase savePurchase(Purchase purchase){
        purchase.setPurchaseTime(LocalDateTime.now());
        return this.purchaseRepository.save(purchase);
    }

    @Override
    public List<PurchaseItem> findAllPurchaseOfUser(Long userId){
        return purchaseRepository.findAllPurchaseOfUser(userId);
    }
}
