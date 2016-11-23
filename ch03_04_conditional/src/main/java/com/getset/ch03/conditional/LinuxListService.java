package com.getset.ch03.conditional;

import org.springframework.stereotype.Service;

/**
 * LinuxListService.
 * Created by Kang on 2016/11/23 0023.
 */
@Service
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
