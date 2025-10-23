package com.example.demo.Lab_5.Service;

import com.example.demo.Lab_5.Entity.ApplicationRequest;
import com.example.demo.Lab_5.Entity.Operators;
import com.example.demo.Lab_5.Repository.AppRequestRepository;
import com.example.demo.Lab_5.Repository.OperatorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppRequestService {

    @Autowired
    private AppRequestRepository appRequestRepository;

    @Autowired
    private OperatorsRepository operatorsRepository;

    public List<ApplicationRequest> getAllApplicationRequests() {
        return appRequestRepository.findAll();
    }

    public ApplicationRequest getApplicationRequestById(String id) {
        return appRequestRepository.findById(id).orElse(null);
    }

    public void saveApplicationRequest(ApplicationRequest request) {
        appRequestRepository.save(request);
    }

    public void deleteApplicationRequest(String id) {
        appRequestRepository.deleteById(id);
    }

    public List<ApplicationRequest> getPendingRequests() {
        return appRequestRepository.findByHandled(false);
    }

    public List<ApplicationRequest> getProcessedRequests() {
        return appRequestRepository.findByHandled(true);
    }

    public void assignOperatorsToRequest(String requestId, List<String> operatorIds){
        ApplicationRequest request = appRequestRepository.findById(requestId).orElse(null);
        List<Operators> operators = new ArrayList<>();
        for (String opId: operatorIds){
            Operators operator = operatorsRepository.findById(opId).orElse(null);
            operators.add(operator);
        }
        request.setOperators(operators);
        request.setHandled(true);

        appRequestRepository.save(request);
    }

    public void removeOperatorFromRequest(String requestId, String operatorId) {
        ApplicationRequest request = getApplicationRequestById(requestId);
        List<Operators> updatedList = new ArrayList<>();
        if (request != null && request.getOperators() != null) {
            for (Operators op: request.getOperators()){
                if (!op.getId().equals(operatorId)){
                    updatedList.add(op);
                }
            }
        }
        request.setOperators(updatedList);
        appRequestRepository.save(request);
    }
}

