package com.example.demo.Lab_5.Service;

import com.example.demo.Lab_5.Entity.ApplicationRequest;
import com.example.demo.Lab_5.Entity.Operators;
import com.example.demo.Lab_5.Repository.AppRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppRequestService {

    @Autowired
    private AppRequestRepository appRequestRepository;

    @Autowired
    private CoursesService coursesService;

    @Autowired
    private OperatorsService operatorsService;

    public List<ApplicationRequest> getAllApplicationRequests() {
        return appRequestRepository.findAll();
    }

    public ApplicationRequest getApplicationRequestById(String id) {
        Optional<ApplicationRequest> request = appRequestRepository.findById(id);
        return request.orElse(null);
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

    public void assignOperatorsToRequest(String requestId, List<String> operatorIds) {
        ApplicationRequest request = getApplicationRequestById(requestId);
        if (request != null) {
            List<Operators> operators = operatorIds.stream()
                    .map(operatorsService::getOperatorById)
                    .toList();
            request.setOperators(operators);
            request.setHandled(true);
            appRequestRepository.save(request);
        }
    }

    public void removeOperatorFromRequest(String requestId, String operatorId) {
        ApplicationRequest request = getApplicationRequestById(requestId);
        if (request != null && request.getOperators() != null) {
            List<Operators> updatedOperators = request.getOperators().stream()
                    .filter(operator -> !operator.getId().equals(operatorId))
                    .toList();
            request.setOperators(updatedOperators);
             appRequestRepository.save(request);
        }
    }
}

