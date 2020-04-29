package com.persistence;

import com.entity.Status;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StatusRepository extends PagingAndSortingRepository<Status, Long> {
}
