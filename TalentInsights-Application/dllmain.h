// dllmain.h : Declaración de clase de módulo.

class CTalentInsightsApplicationModule : public ATL::CAtlDllModuleT< CTalentInsightsApplicationModule >
{
public :
	DECLARE_LIBID(LIBID_TalentInsightsApplicationLib)
	DECLARE_REGISTRY_APPID_RESOURCEID(IDR_TALENTINSIGHTSAPPLICATION, "{eb1ad8e3-c38d-46ee-86f5-36a04fd150dd}")
};

extern class CTalentInsightsApplicationModule _AtlModule;
