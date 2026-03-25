// dllmain.cpp : Implementación de DllMain.

#include "pch.h"
#include "framework.h"
#include "resource.h"
#include "TalentInsightsApplication_i.h"
#include "dllmain.h"

CTalentInsightsApplicationModule _AtlModule;

// Punto de entrada del archivo DLL
extern "C" BOOL WINAPI DllMain(HINSTANCE hInstance, DWORD dwReason, LPVOID lpReserved)
{
	hInstance;
	return _AtlModule.DllMain(dwReason, lpReserved);
}
