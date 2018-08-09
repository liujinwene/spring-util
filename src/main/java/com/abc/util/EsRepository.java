package com.abc.util;

import com.abc.dto.content.Content;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface EsRepository extends ElasticsearchRepository<Content, String> {
}
