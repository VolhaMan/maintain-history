package com.stock.history.maintainhistory.component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.stock.history.maintainhistory.service.UpdateHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateHistory {

    @Autowired
    UpdateHistoryService updateHistoryService;

    @Scheduled(fixedRate = 15000)
    public void update() throws JsonProcessingException {
        log.info("Scheduler triggered.");
        updateHistoryService.updateHistory();
    }
}
