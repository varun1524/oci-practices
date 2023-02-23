import json

from fdk import response


def handler(ctx, func_input):
    print("func_input: ", func_input)
    print("ctx: ", ctx)
    resp = {"foo": "bar"}

    return response.Response(
        ctx,
        response_data=json.dumps(resp),
        headers={"Content-Type": "application/json"}
    )
