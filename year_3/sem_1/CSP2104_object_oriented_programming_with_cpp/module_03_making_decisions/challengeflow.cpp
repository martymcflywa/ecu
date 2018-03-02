bool isBusinessVertical;
bool isProcessesDifferentiating;
bool isImpedimentsToOutsourcing;
bool isImpedimentsToCloudAdoption;
bool isPrimaryBusinessDriverCloudCompatible;
bool isSolutionAPlatform;
bool isApplicationInsulatedFromBusiness;
bool isDifferentiationItBased;
bool isCustomHardwareOsAndApp;
bool isCustomHardwareAndOs;

void handleImpedimentsToOutsourcing()
{
    if(isImpedimentsToOutsourcing)
        if(isSolutionAPlatform)
            if(isImpedimentsToCloudAdoption)
                redLight();
    else
        if(isImpedimentsToCloudAdoption)
            redLight();
        else
            if(isPrimaryBusinessDriverCloudCompatible)
                greenLight();
            else
                redLight();
}

void greenLight()
{

}

void redLight()
{

}

int main()
{
    if(isBusinessVertical)
        if(isProcessesDifferentiating)
            if(isApplicationInsulatedFromBusiness)
                if(isDifferentiationItBased)
                    if(isCustomHardwareOsAndApp)
                        redLight();
                    else
                        if(isCustomHardwareAndOs)
                            redLight();
                        else
                            handleImpedimentsToOutsourcing();
                else
                    handleImpedimentsToOutsourcing();
            else
                redLight();
        else
            handleImpedimentsToOutsourcing();
    else
        handleImpedimentsToOutsourcing();

    return 0;
}