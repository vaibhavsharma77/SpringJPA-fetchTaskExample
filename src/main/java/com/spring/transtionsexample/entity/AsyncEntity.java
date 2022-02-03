package com.spring.transtionsexample.entity;

import com.spring.transtionsexample.util.AsyncTaskStatus;
import com.spring.transtionsexample.util.ProcessingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "async_table")
public class AsyncEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String caseId;
    @Enumerated(EnumType.STRING)
    private AsyncTaskStatus status;
    private int attempt;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;

}
