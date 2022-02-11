package dev.alnat.githubcitest.service;

import dev.alnat.todoit.types.AttachmentPreview;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by @author AlNat on 11.02.2022.
 * Licensed by Apache License, Version 2.0
 */
@Service
@RequiredArgsConstructor
public class TestService {

    private final JdbcTemplate template;

    public Boolean test() {
        return template.queryForObject("SELECT 1=1", new SingleColumnRowMapper<>(Boolean.class));
    }

    public AttachmentPreview getDependency() {
        AttachmentPreview preview = new AttachmentPreview();
        preview.setCreated(LocalDateTime.MIN);
        return preview;
    }

}
