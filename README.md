# Global Privacy Control (GPC) for Android: Proof of Concept

> **DISCLAIMER:** THIS CODE IS NOT FOR PRODUCTION USE. The purpose of this proof of concept is solely to investigate and demonstrate the technical feasibility of expressing signals through Android's platform APIs. The UI components are necessary for demonstration but it not the primary goal.

This repository contains a **PROOF OF CONCEPT** implementation of the [Global Privacy Control (GPC)](https://globalprivacycontrol.org) for Android.

To accomplish this, this repo contains the code for two apps: 1) a GPC Control app, in which users can control the GPC signal (i.e. set or unset it), and 2) a Test app which shows how to query the current GPC value (set or unset).

The code was tested on a Pixel 4 running the latest Android 13, with each app signed with different certificates in a release build.

The following shows one screenshot for each of the two apps:

<p align="center">
    <img alt="Screenshot of GPC Control app" src="screenshots/consent_app.png" style="margin: 0 auto;" height="100%" width="25%" >
    <img alt="Screenshot of Test app" src="screenshots/test_app.png" style="margin: 0 auto;" height="100%" width="25%" >
</p>

Note that the interpretation of GPC should be according to the jurisdictional regulations that are applicable. As per the [GPC spec regarding Legal Effects](https://globalprivacycontrol.github.io/gpc-spec/#legal-effects), a set value of GPC may mean the following: for CCPA (California, USA) and NRS 603A (Nevada, USA) the signal communicates a Do Not Sell request, under the CPA (Colorado, USA) and CDPA (Connecticut, USA) the signal communicates a request to opt out of both the sale of their personal information and the use of their personal information for targeted advertising, under GDPR (EU) the signal communicates a request that data controllers limit the sale or sharing of the person's personal data to other data controllers
