package com.getset.ch03.conditional;

import org.springframework.stereotype.Service;

/**
 * WindowsListService.
 * Created by Kang on 2016/11/23 0023.
 */
@Service
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
