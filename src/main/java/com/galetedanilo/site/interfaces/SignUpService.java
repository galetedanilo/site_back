package com.galetedanilo.site.interfaces;

import com.galetedanilo.site.requests.NewAccountRequest;
import com.galetedanilo.site.responses.NewAccountResponse;

public interface SignUpService {
    public NewAccountResponse registerNewAccount(NewAccountRequest newAccountRequest);
}
