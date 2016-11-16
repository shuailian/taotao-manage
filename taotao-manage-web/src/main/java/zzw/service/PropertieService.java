package zzw.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by john on 2016/11/16.
 */
@Service
public class PropertieService {
    @Value("${REPOSITORY_PATH}")
    public static String REPOSITORY_PATH ="F:\\照片";
    @Value("${IMAGE_BASE_URL}")
    public static String IMAGE_BASE_URL="http://image.taotao.com";

}
