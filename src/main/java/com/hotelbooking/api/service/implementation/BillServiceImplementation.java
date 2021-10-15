package com.hotelbooking.api.service.implementation;

import java.util.List;

import com.hotelbooking.api.entity.Bill;
import com.hotelbooking.api.repository.BillRepository;
import com.hotelbooking.api.service.BillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImplementation implements BillService{
    @Autowired
    private BillRepository billRepository;

    @Override
    public void create(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Bill get(Long id) {
        return billRepository.findById(id).get();
    }

    @Override
    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    @Override
    public void update(Bill bill) {
        if(billRepository.existsById(bill.getId())){
            Bill _bill = billRepository.getById(bill.getId());

            if(bill.getBooking() != null && bill.getBooking() != _bill.getBooking())
                _bill.setBooking(bill.getBooking());

            if(bill.getDiscountPercentage() != _bill.getDiscountPercentage())
                _bill.setDiscountPercentage(bill.getDiscountPercentage());
            
            if(bill.getPaymentMethod() != null && bill.getPaymentMethod() != _bill.getPaymentMethod())
                _bill.setPaymentMethod(bill.getPaymentMethod());

            billRepository.save(_bill);

        }
    }

    @Override
    public void delete(Long id) {
        if(billRepository.existsById(id))
            billRepository.deleteById(id);
    }
    
}
