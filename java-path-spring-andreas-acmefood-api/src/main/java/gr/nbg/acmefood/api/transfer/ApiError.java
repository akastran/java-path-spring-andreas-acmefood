package gr.nbg.acmefood.api.transfer;

public record ApiError(Integer status, String message, String path) {
}
