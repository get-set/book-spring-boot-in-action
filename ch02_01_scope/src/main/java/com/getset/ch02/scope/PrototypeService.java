package com.getset.ch02.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * This is a prototype service.
 * Created by Kang on 2016/11/8 0008.
 */
@Service
@Scope("prototype")
public class PrototypeService {
}
