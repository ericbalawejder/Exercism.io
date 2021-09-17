class AnnalynsInfiltration {

    static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake && !archerIsAwake;
    }

    static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake,
                                          boolean prisonerIsAwake, boolean petDogIsPresent) {
        return !knightIsAwake && !archerIsAwake && prisonerIsAwake ||
                !archerIsAwake && petDogIsPresent;
    }

}
