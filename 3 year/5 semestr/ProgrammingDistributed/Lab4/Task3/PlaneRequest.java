package Task3;

import java.util.Objects;

public class PlaneRequest {
    private final int planeId;
    private final int priority;

    public PlaneRequest(int planeId, boolean isLanding, int fuel) {
        this.planeId = planeId;
        this.priority = isLanding ? fuel : Integer.MAX_VALUE;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PlaneRequest) {
            return this.planeId == ((PlaneRequest) obj).planeId;
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeId);
    }
}
