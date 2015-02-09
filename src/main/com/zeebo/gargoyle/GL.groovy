package com.zeebo.gargoyle

import org.lwjgl.PointerBuffer
import org.lwjgl.PointerWrapper
import org.lwjgl.opengl.*

import java.nio.*

/**
 * User: Eric
 */
class GL {

	public static final int GL_NEGATIVE_ONE_TO_ONE = 37726
	public static final int GL_ZERO_TO_ONE = 37727
	public static final int GL_CLIP_ORIGIN = 37724
	public static final int GL_CLIP_DEPTH_MODE = 37725
	public static final int GL_QUERY_WAIT_INVERTED = 36375
	public static final int GL_QUERY_NO_WAIT_INVERTED = 36376
	public static final int GL_QUERY_BY_REGION_WAIT_INVERTED = 36377
	public static final int GL_QUERY_BY_REGION_NO_WAIT_INVERTED = 36378
	public static final int GL_MAX_CULL_DISTANCES = 33529
	public static final int GL_MAX_COMBINED_CLIP_AND_CULL_DISTANCES = 33530
	public static final int GL_TEXTURE_TARGET = 4102
	public static final int GL_QUERY_TARGET = 33514
	public static final int GL_TEXTURE_BINDING = 33515
	public static final int GL_CONTEXT_RELEASE_BEHAVIOR = 33531
	public static final int GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 33532
	public static final int GL_GUILTY_CONTEXT_RESET = 33363
	public static final int GL_INNOCENT_CONTEXT_RESET = 33364
	public static final int GL_UNKNOWN_CONTEXT_RESET = 33365
	public static final int GL_CONTEXT_ROBUST_ACCESS = 37107
	public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366
	public static final int GL_LOSE_CONTEXT_ON_RESET = 33362
	public static final int GL_NO_RESET_NOTIFICATION = 33377
	public static final int GL_CONTEXT_LOST = 1287
	public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 33509
	public static final int GL_MAP_PERSISTENT_BIT = 64
	public static final int GL_MAP_COHERENT_BIT = 128
	public static final int GL_DYNAMIC_STORAGE_BIT = 256
	public static final int GL_CLIENT_STORAGE_BIT = 512
	public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311
	public static final int GL_BUFFER_STORAGE_FLAGS = 33312
	public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384
	public static final int GL_CLEAR_TEXTURE = 37733
	public static final int GL_LOCATION_COMPONENT = 37706
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER_INDEX = 37707
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER_STRIDE = 37708
	public static final int GL_QUERY_RESULT_NO_WAIT = 37268
	public static final int GL_QUERY_BUFFER = 37266
	public static final int GL_QUERY_BUFFER_BINDING = 37267
	public static final int GL_QUERY_BUFFER_BARRIER_BIT = 32768
	public static final int GL_MIRROR_CLAMP_TO_EDGE = 34627
	public static final int GL_NUM_SHADING_LANGUAGE_VERSIONS = 33513
	public static final int GL_VERTEX_ATTRIB_ARRAY_LONG = 34638
	public static final int GL_COMPRESSED_RGB8_ETC2 = 37492
	public static final int GL_COMPRESSED_SRGB8_ETC2 = 37493
	public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37494
	public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37495
	public static final int GL_COMPRESSED_RGBA8_ETC2_EAC = 37496
	public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC = 37497
	public static final int GL_COMPRESSED_R11_EAC = 37488
	public static final int GL_COMPRESSED_SIGNED_R11_EAC = 37489
	public static final int GL_COMPRESSED_RG11_EAC = 37490
	public static final int GL_COMPRESSED_SIGNED_RG11_EAC = 37491
	public static final int GL_PRIMITIVE_RESTART_FIXED_INDEX = 36201
	public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE = 36202
	public static final int GL_MAX_ELEMENT_INDEX = 36203
	public static final int GL_COMPUTE_SHADER = 37305
	public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 37307
	public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 37308
	public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 37309
	public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 33378
	public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 33379
	public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 33380
	public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 33381
	public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 33382
	public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 37099
	public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 37310
	public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 37311
	public static final int GL_COMPUTE_WORK_GROUP_SIZE = 33383
	public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER = 37100
	public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER = 37101
	public static final int GL_DISPATCH_INDIRECT_BUFFER = 37102
	public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 37103
	public static final int GL_COMPUTE_SHADER_BIT = 32
	public static final int GL_DEBUG_OUTPUT = 37600
	public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346
	public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2
	public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187
	public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188
	public static final int GL_DEBUG_LOGGED_MESSAGES = 37189
	public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347
	public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388
	public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389
	public static final int GL_MAX_LABEL_LENGTH = 33512
	public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348
	public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349
	public static final int GL_DEBUG_SOURCE_API = 33350
	public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351
	public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352
	public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353
	public static final int GL_DEBUG_SOURCE_APPLICATION = 33354
	public static final int GL_DEBUG_SOURCE_OTHER = 33355
	public static final int GL_DEBUG_TYPE_ERROR = 33356
	public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357
	public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358
	public static final int GL_DEBUG_TYPE_PORTABILITY = 33359
	public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360
	public static final int GL_DEBUG_TYPE_OTHER = 33361
	public static final int GL_DEBUG_TYPE_MARKER = 33384
	public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385
	public static final int GL_DEBUG_TYPE_POP_GROUP = 33386
	public static final int GL_DEBUG_SEVERITY_HIGH = 37190
	public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191
	public static final int GL_DEBUG_SEVERITY_LOW = 37192
	public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387
	public static final int GL_BUFFER = 33504
	public static final int GL_SHADER = 33505
	public static final int GL_PROGRAM = 33506
	public static final int GL_QUERY = 33507
	public static final int GL_PROGRAM_PIPELINE = 33508
	public static final int GL_SAMPLER = 33510
	public static final int GL_DISPLAY_LIST = 33511
	public static final int GL_MAX_UNIFORM_LOCATIONS = 33390
	public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648
	public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649
	public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650
	public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651
	public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652
	public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653
	public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654
	public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655
	public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656
	public static final int GL_INTERNALFORMAT_SUPPORTED = 33391
	public static final int GL_INTERNALFORMAT_PREFERRED = 33392
	public static final int GL_INTERNALFORMAT_RED_SIZE = 33393
	public static final int GL_INTERNALFORMAT_GREEN_SIZE = 33394
	public static final int GL_INTERNALFORMAT_BLUE_SIZE = 33395
	public static final int GL_INTERNALFORMAT_ALPHA_SIZE = 33396
	public static final int GL_INTERNALFORMAT_DEPTH_SIZE = 33397
	public static final int GL_INTERNALFORMAT_STENCIL_SIZE = 33398
	public static final int GL_INTERNALFORMAT_SHARED_SIZE = 33399
	public static final int GL_INTERNALFORMAT_RED_TYPE = 33400
	public static final int GL_INTERNALFORMAT_GREEN_TYPE = 33401
	public static final int GL_INTERNALFORMAT_BLUE_TYPE = 33402
	public static final int GL_INTERNALFORMAT_ALPHA_TYPE = 33403
	public static final int GL_INTERNALFORMAT_DEPTH_TYPE = 33404
	public static final int GL_INTERNALFORMAT_STENCIL_TYPE = 33405
	public static final int GL_MAX_WIDTH = 33406
	public static final int GL_MAX_HEIGHT = 33407
	public static final int GL_MAX_DEPTH = 33408
	public static final int GL_MAX_LAYERS = 33409
	public static final int GL_MAX_COMBINED_DIMENSIONS = 33410
	public static final int GL_COLOR_COMPONENTS = 33411
	public static final int GL_DEPTH_COMPONENTS = 33412
	public static final int GL_STENCIL_COMPONENTS = 33413
	public static final int GL_COLOR_RENDERABLE = 33414
	public static final int GL_DEPTH_RENDERABLE = 33415
	public static final int GL_STENCIL_RENDERABLE = 33416
	public static final int GL_FRAMEBUFFER_RENDERABLE = 33417
	public static final int GL_FRAMEBUFFER_RENDERABLE_LAYERED = 33418
	public static final int GL_FRAMEBUFFER_BLEND = 33419
	public static final int GL_READ_PIXELS = 33420
	public static final int GL_READ_PIXELS_FORMAT = 33421
	public static final int GL_READ_PIXELS_TYPE = 33422
	public static final int GL_TEXTURE_IMAGE_FORMAT = 33423
	public static final int GL_TEXTURE_IMAGE_TYPE = 33424
	public static final int GL_GET_TEXTURE_IMAGE_FORMAT = 33425
	public static final int GL_GET_TEXTURE_IMAGE_TYPE = 33426
	public static final int GL_MIPMAP = 33427
	public static final int GL_MANUAL_GENERATE_MIPMAP = 33428
	public static final int GL_AUTO_GENERATE_MIPMAP = 33429
	public static final int GL_COLOR_ENCODING = 33430
	public static final int GL_SRGB_READ = 33431
	public static final int GL_SRGB_WRITE = 33432
	public static final int GL_SRGB_DECODE_ARB = 33433
	public static final int GL_FILTER = 33434
	public static final int GL_VERTEX_TEXTURE = 33435
	public static final int GL_TESS_CONTROL_TEXTURE = 33436
	public static final int GL_TESS_EVALUATION_TEXTURE = 33437
	public static final int GL_GEOMETRY_TEXTURE = 33438
	public static final int GL_FRAGMENT_TEXTURE = 33439
	public static final int GL_COMPUTE_TEXTURE = 33440
	public static final int GL_TEXTURE_SHADOW = 33441
	public static final int GL_TEXTURE_GATHER = 33442
	public static final int GL_TEXTURE_GATHER_SHADOW = 33443
	public static final int GL_SHADER_IMAGE_LOAD = 33444
	public static final int GL_SHADER_IMAGE_STORE = 33445
	public static final int GL_SHADER_IMAGE_ATOMIC = 33446
	public static final int GL_IMAGE_TEXEL_SIZE = 33447
	public static final int GL_IMAGE_COMPATIBILITY_CLASS = 33448
	public static final int GL_IMAGE_PIXEL_FORMAT = 33449
	public static final int GL_IMAGE_PIXEL_TYPE = 33450
	public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST = 33452
	public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST = 33453
	public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE = 33454
	public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE = 33455
	public static final int GL_TEXTURE_COMPRESSED_BLOCK_WIDTH = 33457
	public static final int GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT = 33458
	public static final int GL_TEXTURE_COMPRESSED_BLOCK_SIZE = 33459
	public static final int GL_CLEAR_BUFFER = 33460
	public static final int GL_TEXTURE_VIEW = 33461
	public static final int GL_VIEW_COMPATIBILITY_CLASS = 33462
	public static final int GL_FULL_SUPPORT = 33463
	public static final int GL_CAVEAT_SUPPORT = 33464
	public static final int GL_IMAGE_CLASS_4_X_32 = 33465
	public static final int GL_IMAGE_CLASS_2_X_32 = 33466
	public static final int GL_IMAGE_CLASS_1_X_32 = 33467
	public static final int GL_IMAGE_CLASS_4_X_16 = 33468
	public static final int GL_IMAGE_CLASS_2_X_16 = 33469
	public static final int GL_IMAGE_CLASS_1_X_16 = 33470
	public static final int GL_IMAGE_CLASS_4_X_8 = 33471
	public static final int GL_IMAGE_CLASS_2_X_8 = 33472
	public static final int GL_IMAGE_CLASS_1_X_8 = 33473
	public static final int GL_IMAGE_CLASS_11_11_10 = 33474
	public static final int GL_IMAGE_CLASS_10_10_10_2 = 33475
	public static final int GL_VIEW_CLASS_128_BITS = 33476
	public static final int GL_VIEW_CLASS_96_BITS = 33477
	public static final int GL_VIEW_CLASS_64_BITS = 33478
	public static final int GL_VIEW_CLASS_48_BITS = 33479
	public static final int GL_VIEW_CLASS_32_BITS = 33480
	public static final int GL_VIEW_CLASS_24_BITS = 33481
	public static final int GL_VIEW_CLASS_16_BITS = 33482
	public static final int GL_VIEW_CLASS_8_BITS = 33483
	public static final int GL_VIEW_CLASS_S3TC_DXT1_RGB = 33484
	public static final int GL_VIEW_CLASS_S3TC_DXT1_RGBA = 33485
	public static final int GL_VIEW_CLASS_S3TC_DXT3_RGBA = 33486
	public static final int GL_VIEW_CLASS_S3TC_DXT5_RGBA = 33487
	public static final int GL_VIEW_CLASS_RGTC1_RED = 33488
	public static final int GL_VIEW_CLASS_RGTC2_RG = 33489
	public static final int GL_VIEW_CLASS_BPTC_UNORM = 33490
	public static final int GL_VIEW_CLASS_BPTC_FLOAT = 33491
	public static final int GL_UNIFORM = 37601
	public static final int GL_UNIFORM_BLOCK = 37602
	public static final int GL_PROGRAM_INPUT = 37603
	public static final int GL_PROGRAM_OUTPUT = 37604
	public static final int GL_BUFFER_VARIABLE = 37605
	public static final int GL_SHADER_STORAGE_BLOCK = 37606
	public static final int GL_VERTEX_SUBROUTINE = 37608
	public static final int GL_TESS_CONTROL_SUBROUTINE = 37609
	public static final int GL_TESS_EVALUATION_SUBROUTINE = 37610
	public static final int GL_GEOMETRY_SUBROUTINE = 37611
	public static final int GL_FRAGMENT_SUBROUTINE = 37612
	public static final int GL_COMPUTE_SUBROUTINE = 37613
	public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 37614
	public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 37615
	public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 37616
	public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 37617
	public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 37618
	public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 37619
	public static final int GL_TRANSFORM_FEEDBACK_VARYING = 37620
	public static final int GL_ACTIVE_RESOURCES = 37621
	public static final int GL_MAX_NAME_LENGTH = 37622
	public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 37623
	public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 37624
	public static final int GL_NAME_LENGTH = 37625
	public static final int GL_TYPE = 37626
	public static final int GL_ARRAY_SIZE = 37627
	public static final int GL_OFFSET = 37628
	public static final int GL_BLOCK_INDEX = 37629
	public static final int GL_ARRAY_STRIDE = 37630
	public static final int GL_MATRIX_STRIDE = 37631
	public static final int GL_IS_ROW_MAJOR = 37632
	public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 37633
	public static final int GL_BUFFER_BINDING = 37634
	public static final int GL_BUFFER_DATA_SIZE = 37635
	public static final int GL_NUM_ACTIVE_VARIABLES = 37636
	public static final int GL_ACTIVE_VARIABLES = 37637
	public static final int GL_REFERENCED_BY_VERTEX_SHADER = 37638
	public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 37639
	public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 37640
	public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 37641
	public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 37642
	public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 37643
	public static final int GL_TOP_LEVEL_ARRAY_SIZE = 37644
	public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 37645
	public static final int GL_LOCATION = 37646
	public static final int GL_LOCATION_INDEX = 37647
	public static final int GL_IS_PER_PATCH = 37607
	public static final int GL_SHADER_STORAGE_BUFFER = 37074
	public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 37075
	public static final int GL_SHADER_STORAGE_BUFFER_START = 37076
	public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 37077
	public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 37078
	public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 37079
	public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 37080
	public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 37081
	public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 37082
	public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 37083
	public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 37084
	public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 37085
	public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 37086
	public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 37087
	public static final int GL_SHADER_STORAGE_BARRIER_BIT = 8192
	public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 36665
	public static final int GL_DEPTH_STENCIL_TEXTURE_MODE = 37098
	public static final int GL_TEXTURE_BUFFER_OFFSET = 37277
	public static final int GL_TEXTURE_BUFFER_SIZE = 37278
	public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279
	public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 33499
	public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 33500
	public static final int GL_TEXTURE_VIEW_MIN_LAYER = 33501
	public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 33502
	public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503
	public static final int GL_VERTEX_ATTRIB_BINDING = 33492
	public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493
	public static final int GL_VERTEX_BINDING_DIVISOR = 33494
	public static final int GL_VERTEX_BINDING_OFFSET = 33495
	public static final int GL_VERTEX_BINDING_STRIDE = 33496
	public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497
	public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498
	public static final int GL_COMPRESSED_RGBA_BPTC_UNORM = 36492
	public static final int GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM = 36493
	public static final int GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT = 36494
	public static final int GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT = 36495
	public static final int GL_UNPACK_COMPRESSED_BLOCK_WIDTH = 37159
	public static final int GL_UNPACK_COMPRESSED_BLOCK_HEIGHT = 37160
	public static final int GL_UNPACK_COMPRESSED_BLOCK_DEPTH = 37161
	public static final int GL_UNPACK_COMPRESSED_BLOCK_SIZE = 37162
	public static final int GL_PACK_COMPRESSED_BLOCK_WIDTH = 37163
	public static final int GL_PACK_COMPRESSED_BLOCK_HEIGHT = 37164
	public static final int GL_PACK_COMPRESSED_BLOCK_DEPTH = 37165
	public static final int GL_PACK_COMPRESSED_BLOCK_SIZE = 37166
	public static final int GL_ATOMIC_COUNTER_BUFFER = 37568
	public static final int GL_ATOMIC_COUNTER_BUFFER_BINDING = 37569
	public static final int GL_ATOMIC_COUNTER_BUFFER_START = 37570
	public static final int GL_ATOMIC_COUNTER_BUFFER_SIZE = 37571
	public static final int GL_ATOMIC_COUNTER_BUFFER_DATA_SIZE = 37572
	public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTERS = 37573
	public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTER_INDICES = 37574
	public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_VERTEX_SHADER = 37575
	public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_CONTROL_SHADER = 37576
	public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_EVALUATION_SHADER = 37577
	public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_GEOMETRY_SHADER = 37578
	public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_FRAGMENT_SHADER = 37579
	public static final int GL_MAX_VERTEX_ATOMIC_COUNTER_BUFFERS = 37580
	public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS = 37581
	public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS = 37582
	public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTER_BUFFERS = 37583
	public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTER_BUFFERS = 37584
	public static final int GL_MAX_COMBINED_ATOMIC_COUNTER_BUFFERS = 37585
	public static final int GL_MAX_VERTEX_ATOMIC_COUNTERS = 37586
	public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS = 37587
	public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS = 37588
	public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTERS = 37589
	public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTERS = 37590
	public static final int GL_MAX_COMBINED_ATOMIC_COUNTERS = 37591
	public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_SIZE = 37592
	public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_BINDINGS = 37596
	public static final int GL_ACTIVE_ATOMIC_COUNTER_BUFFERS = 37593
	public static final int GL_UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX = 37594
	public static final int GL_UNSIGNED_INT_ATOMIC_COUNTER = 37595
	public static final int GL_TEXTURE_IMMUTABLE_FORMAT = 37167
	public static final int GL_MAX_IMAGE_UNITS = 36664
	public static final int GL_MAX_COMBINED_IMAGE_UNITS_AND_FRAGMENT_OUTPUTS = 36665
	public static final int GL_MAX_IMAGE_SAMPLES = 36973
	public static final int GL_MAX_VERTEX_IMAGE_UNIFORMS = 37066
	public static final int GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS = 37067
	public static final int GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS = 37068
	public static final int GL_MAX_GEOMETRY_IMAGE_UNIFORMS = 37069
	public static final int GL_MAX_FRAGMENT_IMAGE_UNIFORMS = 37070
	public static final int GL_MAX_COMBINED_IMAGE_UNIFORMS = 37071
	public static final int GL_IMAGE_BINDING_NAME = 36666
	public static final int GL_IMAGE_BINDING_LEVEL = 36667
	public static final int GL_IMAGE_BINDING_LAYERED = 36668
	public static final int GL_IMAGE_BINDING_LAYER = 36669
	public static final int GL_IMAGE_BINDING_ACCESS = 36670
	public static final int GL_IMAGE_BINDING_FORMAT = 36974
	public static final int GL_VERTEX_ATTRIB_ARRAY_BARRIER_BIT = 1
	public static final int GL_ELEMENT_ARRAY_BARRIER_BIT = 2
	public static final int GL_UNIFORM_BARRIER_BIT = 4
	public static final int GL_TEXTURE_FETCH_BARRIER_BIT = 8
	public static final int GL_SHADER_IMAGE_ACCESS_BARRIER_BIT = 32
	public static final int GL_COMMAND_BARRIER_BIT = 64
	public static final int GL_PIXEL_BUFFER_BARRIER_BIT = 128
	public static final int GL_TEXTURE_UPDATE_BARRIER_BIT = 256
	public static final int GL_BUFFER_UPDATE_BARRIER_BIT = 512
	public static final int GL_FRAMEBUFFER_BARRIER_BIT = 1024
	public static final int GL_TRANSFORM_FEEDBACK_BARRIER_BIT = 2048
	public static final int GL_ATOMIC_COUNTER_BARRIER_BIT = 4096
	public static final int GL_ALL_BARRIER_BITS = -1
	public static final int GL_IMAGE_1D = 36940
	public static final int GL_IMAGE_2D = 36941
	public static final int GL_IMAGE_3D = 36942
	public static final int GL_IMAGE_2D_RECT = 36943
	public static final int GL_IMAGE_CUBE = 36944
	public static final int GL_IMAGE_BUFFER = 36945
	public static final int GL_IMAGE_1D_ARRAY = 36946
	public static final int GL_IMAGE_2D_ARRAY = 36947
	public static final int GL_IMAGE_CUBE_MAP_ARRAY = 36948
	public static final int GL_IMAGE_2D_MULTISAMPLE = 36949
	public static final int GL_IMAGE_2D_MULTISAMPLE_ARRAY = 36950
	public static final int GL_INT_IMAGE_1D = 36951
	public static final int GL_INT_IMAGE_2D = 36952
	public static final int GL_INT_IMAGE_3D = 36953
	public static final int GL_INT_IMAGE_2D_RECT = 36954
	public static final int GL_INT_IMAGE_CUBE = 36955
	public static final int GL_INT_IMAGE_BUFFER = 36956
	public static final int GL_INT_IMAGE_1D_ARRAY = 36957
	public static final int GL_INT_IMAGE_2D_ARRAY = 36958
	public static final int GL_INT_IMAGE_CUBE_MAP_ARRAY = 36959
	public static final int GL_INT_IMAGE_2D_MULTISAMPLE = 36960
	public static final int GL_INT_IMAGE_2D_MULTISAMPLE_ARRAY = 36961
	public static final int GL_UNSIGNED_INT_IMAGE_1D = 36962
	public static final int GL_UNSIGNED_INT_IMAGE_2D = 36963
	public static final int GL_UNSIGNED_INT_IMAGE_3D = 36964
	public static final int GL_UNSIGNED_INT_IMAGE_2D_RECT = 36965
	public static final int GL_UNSIGNED_INT_IMAGE_CUBE = 36966
	public static final int GL_UNSIGNED_INT_IMAGE_BUFFER = 36967
	public static final int GL_UNSIGNED_INT_IMAGE_1D_ARRAY = 36968
	public static final int GL_UNSIGNED_INT_IMAGE_2D_ARRAY = 36969
	public static final int GL_UNSIGNED_INT_IMAGE_CUBE_MAP_ARRAY = 36970
	public static final int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE = 36971
	public static final int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY = 36972
	public static final int GL_IMAGE_FORMAT_COMPATIBILITY_TYPE = 37063
	public static final int GL_IMAGE_FORMAT_COMPATIBILITY_BY_SIZE = 37064
	public static final int IMAGE_FORMAT_COMPATIBILITY_BY_CLASS = 37065
	public static final int GL_NUM_SAMPLE_COUNTS = 37760
	public static final int GL_MIN_MAP_BUFFER_ALIGNMENT = 37052
	public static final int GL_SHADER_COMPILER = 36346
	public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345
	public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347
	public static final int GL_MAX_VARYING_VECTORS = 36348
	public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 36349
	public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 35738
	public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 35739
	public static final int GL_FIXED = 5132
	public static final int GL_LOW_FLOAT = 36336
	public static final int GL_MEDIUM_FLOAT = 36337
	public static final int GL_HIGH_FLOAT = 36338
	public static final int GL_LOW_INT = 36339
	public static final int GL_MEDIUM_INT = 36340
	public static final int GL_HIGH_INT = 36341
	public static final int GL_RGB565 = 36194
	public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367
	public static final int GL_PROGRAM_BINARY_LENGTH = 34625
	public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814
	public static final int GL_PROGRAM_BINARY_FORMATS = 34815
	public static final int GL_VERTEX_SHADER_BIT = 1
	public static final int GL_FRAGMENT_SHADER_BIT = 2
	public static final int GL_GEOMETRY_SHADER_BIT = 4
	public static final int GL_TESS_CONTROL_SHADER_BIT = 8
	public static final int GL_TESS_EVALUATION_SHADER_BIT = 16
	public static final int GL_ALL_SHADER_BITS = -1
	public static final int GL_PROGRAM_SEPARABLE = 33368
	public static final int GL_ACTIVE_PROGRAM = 33369
	public static final int GL_PROGRAM_PIPELINE_BINDING = 33370
	public static final int GL_MAX_VIEWPORTS = 33371
	public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372
	public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373
	public static final int GL_LAYER_PROVOKING_VERTEX = 33374
	public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375
	public static final int GL_UNDEFINED_VERTEX = 33376
	public static final int GL_DRAW_INDIRECT_BUFFER = 36671
	public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675
	public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943
	public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442
	public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 36443
	public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 36444
	public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 36445
	public static final int GL_MAX_VERTEX_STREAMS = 36465
	public static final int GL_DOUBLE_VEC2 = 36860
	public static final int GL_DOUBLE_VEC3 = 36861
	public static final int GL_DOUBLE_VEC4 = 36862
	public static final int GL_DOUBLE_MAT2 = 36678
	public static final int GL_DOUBLE_MAT3 = 36679
	public static final int GL_DOUBLE_MAT4 = 36680
	public static final int GL_DOUBLE_MAT2x3 = 36681
	public static final int GL_DOUBLE_MAT2x4 = 36682
	public static final int GL_DOUBLE_MAT3x2 = 36683
	public static final int GL_DOUBLE_MAT3x4 = 36684
	public static final int GL_DOUBLE_MAT4x2 = 36685
	public static final int GL_DOUBLE_MAT4x3 = 36686
	public static final int GL_SAMPLE_SHADING = 35894
	public static final int GL_MIN_SAMPLE_SHADING_VALUE = 35895
	public static final int GL_ACTIVE_SUBROUTINES = 36325
	public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326
	public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423
	public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424
	public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425
	public static final int GL_MAX_SUBROUTINES = 36327
	public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328
	public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426
	public static final int GL_COMPATIBLE_SUBROUTINES = 36427
	public static final int GL_PATCHES = 14
	public static final int GL_PATCH_VERTICES = 36466
	public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 36467
	public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 36468
	public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469
	public static final int GL_TESS_GEN_MODE = 36470
	public static final int GL_TESS_GEN_SPACING = 36471
	public static final int GL_TESS_GEN_VERTEX_ORDER = 36472
	public static final int GL_TESS_GEN_POINT_MODE = 36473
	public static final int GL_ISOLINES = 36474
	public static final int GL_FRACTIONAL_ODD = 36475
	public static final int GL_FRACTIONAL_EVEN = 36476
	public static final int GL_MAX_PATCH_VERTICES = 36477
	public static final int GL_MAX_TESS_GEN_LEVEL = 36478
	public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479
	public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480
	public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481
	public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482
	public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483
	public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484
	public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485
	public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486
	public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489
	public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490
	public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924
	public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925
	public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382
	public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383
	public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 34032
	public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 34033
	public static final int GL_TESS_EVALUATION_SHADER = 36487
	public static final int GL_TESS_CONTROL_SHADER = 36488
	public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873
	public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 36874
	public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY = 36875
	public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 36876
	public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 36877
	public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 36878
	public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 36879
	public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 36446
	public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 36447
	public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_COMPONENTS_ARB = 36767
	public static final int GL_TRANSFORM_FEEDBACK = 36386
	public static final int GL_TRANSFORM_FEEDBACK_PAUSED = 36387
	public static final int GL_TRANSFORM_FEEDBACK_ACTIVE = 36388
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388
	public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389
	public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464
	public static final int GL_SRC1_COLOR = 35065
	public static final int GL_ONE_MINUS_SRC1_COLOR = 35066
	public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067
	public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068
	public static final int GL_ANY_SAMPLES_PASSED = 35887
	public static final int GL_SAMPLER_BINDING = 35097
	public static final int GL_RGB10_A2UI = 36975
	public static final int GL_TEXTURE_SWIZZLE_R = 36418
	public static final int GL_TEXTURE_SWIZZLE_G = 36419
	public static final int GL_TEXTURE_SWIZZLE_B = 36420
	public static final int GL_TEXTURE_SWIZZLE_A = 36421
	public static final int GL_TEXTURE_SWIZZLE_RGBA = 36422
	public static final int GL_TIME_ELAPSED = 35007
	public static final int GL_TIMESTAMP = 36392
	public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 35070
	public static final int GL_INT_2_10_10_10_REV = 36255
	public static final int GL_CONTEXT_PROFILE_MASK = 37158
	public static final int GL_CONTEXT_CORE_PROFILE_BIT = 1
	public static final int GL_CONTEXT_COMPATIBILITY_PROFILE_BIT = 2
	public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS = 37154
	public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS = 37155
	public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS = 37156
	public static final int GL_MAX_FRAGMENT_INPUT_COMPONENTS = 37157
	public static final int GL_FIRST_VERTEX_CONVENTION = 36429
	public static final int GL_LAST_VERTEX_CONVENTION = 36430
	public static final int GL_PROVOKING_VERTEX = 36431
	public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 36428
	public static final int GL_TEXTURE_CUBE_MAP_SEAMLESS = 34895
	public static final int GL_SAMPLE_POSITION = 36432
	public static final int GL_SAMPLE_MASK = 36433
	public static final int GL_SAMPLE_MASK_VALUE = 36434
	public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120
	public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121
	public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122
	public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123
	public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441
	public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134
	public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135
	public static final int GL_MAX_INTEGER_SAMPLES = 37136
	public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124
	public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125
	public static final int GL_TEXTURE_SAMPLES = 37126
	public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127
	public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128
	public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129
	public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130
	public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131
	public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132
	public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133
	public static final int GL_DEPTH_CLAMP = 34383
	public static final int GL_GEOMETRY_SHADER = 36313
	public static final int GL_GEOMETRY_VERTICES_OUT = 36314
	public static final int GL_GEOMETRY_INPUT_TYPE = 36315
	public static final int GL_GEOMETRY_OUTPUT_TYPE = 36316
	public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS = 35881
	public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS = 36319
	public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES = 36320
	public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS = 36321
	public static final int GL_LINES_ADJACENCY = 10
	public static final int GL_LINE_STRIP_ADJACENCY = 11
	public static final int GL_TRIANGLES_ADJACENCY = 12
	public static final int GL_TRIANGLE_STRIP_ADJACENCY = 13
	public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 36264
	public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED = 36263
	public static final int GL_PROGRAM_POINT_SIZE = 34370
	public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137
	public static final int GL_OBJECT_TYPE = 37138
	public static final int GL_SYNC_CONDITION = 37139
	public static final int GL_SYNC_STATUS = 37140
	public static final int GL_SYNC_FLAGS = 37141
	public static final int GL_SYNC_FENCE = 37142
	public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143
	public static final int GL_UNSIGNALED = 37144
	public static final int GL_SIGNALED = 37145
	public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1
	public static final long GL_TIMEOUT_IGNORED = -1
	public static final int GL_ALREADY_SIGNALED = 37146
	public static final int GL_TIMEOUT_EXPIRED = 37147
	public static final int GL_CONDITION_SATISFIED = 37148
	public static final int GL_WAIT_FAILED = 37149
	public static final int GL_RED_SNORM = 36752
	public static final int GL_RG_SNORM = 36753
	public static final int GL_RGB_SNORM = 36754
	public static final int GL_RGBA_SNORM = 36755
	public static final int GL_R8_SNORM = 36756
	public static final int GL_RG8_SNORM = 36757
	public static final int GL_RGB8_SNORM = 36758
	public static final int GL_RGBA8_SNORM = 36759
	public static final int GL_R16_SNORM = 36760
	public static final int GL_RG16_SNORM = 36761
	public static final int GL_RGB16_SNORM = 36762
	public static final int GL_RGBA16_SNORM = 36763
	public static final int GL_SIGNED_NORMALIZED = 36764
	public static final int GL_COPY_READ_BUFFER_BINDING = 36662
	public static final int GL_COPY_WRITE_BUFFER_BINDING = 36663
	public static final int GL_COPY_READ_BUFFER = 36662
	public static final int GL_COPY_WRITE_BUFFER = 36663
	public static final int GL_PRIMITIVE_RESTART = 36765
	public static final int GL_PRIMITIVE_RESTART_INDEX = 36766
	public static final int GL_TEXTURE_BUFFER = 35882
	public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 35883
	public static final int GL_TEXTURE_BINDING_BUFFER = 35884
	public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 35885
	public static final int GL_TEXTURE_BUFFER_FORMAT = 35886
	public static final int GL_TEXTURE_RECTANGLE = 34037
	public static final int GL_TEXTURE_BINDING_RECTANGLE = 34038
	public static final int GL_PROXY_TEXTURE_RECTANGLE = 34039
	public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 34040
	public static final int GL_SAMPLER_2D_RECT = 35683
	public static final int GL_SAMPLER_2D_RECT_SHADOW = 35684
	public static final int GL_UNIFORM_BUFFER = 35345
	public static final int GL_UNIFORM_BUFFER_BINDING = 35368
	public static final int GL_UNIFORM_BUFFER_START = 35369
	public static final int GL_UNIFORM_BUFFER_SIZE = 35370
	public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371
	public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372
	public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373
	public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374
	public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375
	public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376
	public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377
	public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378
	public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379
	public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 35380
	public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381
	public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382
	public static final int GL_UNIFORM_TYPE = 35383
	public static final int GL_UNIFORM_SIZE = 35384
	public static final int GL_UNIFORM_NAME_LENGTH = 35385
	public static final int GL_UNIFORM_BLOCK_INDEX = 35386
	public static final int GL_UNIFORM_OFFSET = 35387
	public static final int GL_UNIFORM_ARRAY_STRIDE = 35388
	public static final int GL_UNIFORM_MATRIX_STRIDE = 35389
	public static final int GL_UNIFORM_IS_ROW_MAJOR = 35390
	public static final int GL_UNIFORM_BLOCK_BINDING = 35391
	public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 35392
	public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 35393
	public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 35394
	public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 35395
	public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 35396
	public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 35397
	public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 35398
	public static final int GL_INVALID_INDEX = -1
	public static final int GL_MAJOR_VERSION = 33307
	public static final int GL_MINOR_VERSION = 33308
	public static final int GL_NUM_EXTENSIONS = 33309
	public static final int GL_CONTEXT_FLAGS = 33310
	public static final int GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT = 1
	public static final int GL_DEPTH_BUFFER = 33315
	public static final int GL_STENCIL_BUFFER = 33316
	public static final int GL_COMPRESSED_RED = 33317
	public static final int GL_COMPRESSED_RG = 33318
	public static final int GL_COMPARE_REF_TO_TEXTURE = 34894
	public static final int GL_CLIP_DISTANCE0 = 12288
	public static final int GL_CLIP_DISTANCE1 = 12289
	public static final int GL_CLIP_DISTANCE2 = 12290
	public static final int GL_CLIP_DISTANCE3 = 12291
	public static final int GL_CLIP_DISTANCE4 = 12292
	public static final int GL_CLIP_DISTANCE5 = 12293
	public static final int GL_CLIP_DISTANCE6 = 12294
	public static final int GL_CLIP_DISTANCE7 = 12295
	public static final int GL_MAX_CLIP_DISTANCES = 3378
	public static final int GL_MAX_VARYING_COMPONENTS = 35659
	public static final int GL_BUFFER_ACCESS_FLAGS = 37151
	public static final int GL_BUFFER_MAP_LENGTH = 37152
	public static final int GL_BUFFER_MAP_OFFSET = 37153
	public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER = 35069
	public static final int GL_SAMPLER_BUFFER = 36290
	public static final int GL_SAMPLER_CUBE_SHADOW = 36293
	public static final int GL_UNSIGNED_INT_VEC2 = 36294
	public static final int GL_UNSIGNED_INT_VEC3 = 36295
	public static final int GL_UNSIGNED_INT_VEC4 = 36296
	public static final int GL_INT_SAMPLER_1D = 36297
	public static final int GL_INT_SAMPLER_2D = 36298
	public static final int GL_INT_SAMPLER_3D = 36299
	public static final int GL_INT_SAMPLER_CUBE = 36300
	public static final int GL_INT_SAMPLER_2D_RECT = 36301
	public static final int GL_INT_SAMPLER_1D_ARRAY = 36302
	public static final int GL_INT_SAMPLER_2D_ARRAY = 36303
	public static final int GL_INT_SAMPLER_BUFFER = 36304
	public static final int GL_UNSIGNED_INT_SAMPLER_1D = 36305
	public static final int GL_UNSIGNED_INT_SAMPLER_2D = 36306
	public static final int GL_UNSIGNED_INT_SAMPLER_3D = 36307
	public static final int GL_UNSIGNED_INT_SAMPLER_CUBE = 36308
	public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 36309
	public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY = 36310
	public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY = 36311
	public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 36312
	public static final int GL_MIN_PROGRAM_TEXEL_OFFSET = 35076
	public static final int GL_MAX_PROGRAM_TEXEL_OFFSET = 35077
	public static final int GL_QUERY_WAIT = 36371
	public static final int GL_QUERY_NO_WAIT = 36372
	public static final int GL_QUERY_BY_REGION_WAIT = 36373
	public static final int GL_QUERY_BY_REGION_NO_WAIT = 36374
	public static final int GL_MAP_READ_BIT = 1
	public static final int GL_MAP_WRITE_BIT = 2
	public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4
	public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8
	public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16
	public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32
	public static final int GL_CLAMP_VERTEX_COLOR = 35098
	public static final int GL_CLAMP_FRAGMENT_COLOR = 35099
	public static final int GL_CLAMP_READ_COLOR = 35100
	public static final int GL_FIXED_ONLY = 35101
	public static final int GL_DEPTH_COMPONENT32F = 36012
	public static final int GL_DEPTH32F_STENCIL8 = 36013
	public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 36269
	public static final int GL_TEXTURE_RED_TYPE = 35856
	public static final int GL_TEXTURE_GREEN_TYPE = 35857
	public static final int GL_TEXTURE_BLUE_TYPE = 35858
	public static final int GL_TEXTURE_ALPHA_TYPE = 35859
	public static final int GL_TEXTURE_LUMINANCE_TYPE = 35860
	public static final int GL_TEXTURE_INTENSITY_TYPE = 35861
	public static final int GL_TEXTURE_DEPTH_TYPE = 35862
	public static final int GL_UNSIGNED_NORMALIZED = 35863
	public static final int GL_RGBA32F = 34836
	public static final int GL_RGB32F = 34837
	public static final int GL_ALPHA32F = 34838
	public static final int GL_RGBA16F = 34842
	public static final int GL_RGB16F = 34843
	public static final int GL_ALPHA16F = 34844
	public static final int GL_R11F_G11F_B10F = 35898
	public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 35899
	public static final int GL_RGB9_E5 = 35901
	public static final int GL_UNSIGNED_INT_5_9_9_9_REV = 35902
	public static final int GL_TEXTURE_SHARED_SIZE = 35903
	public static final int GL_FRAMEBUFFER = 36160
	public static final int GL_READ_FRAMEBUFFER = 36008
	public static final int GL_DRAW_FRAMEBUFFER = 36009
	public static final int GL_RENDERBUFFER = 36161
	public static final int GL_STENCIL_INDEX1 = 36166
	public static final int GL_STENCIL_INDEX4 = 36167
	public static final int GL_STENCIL_INDEX8 = 36168
	public static final int GL_STENCIL_INDEX16 = 36169
	public static final int GL_RENDERBUFFER_WIDTH = 36162
	public static final int GL_RENDERBUFFER_HEIGHT = 36163
	public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 36164
	public static final int GL_RENDERBUFFER_RED_SIZE = 36176
	public static final int GL_RENDERBUFFER_GREEN_SIZE = 36177
	public static final int GL_RENDERBUFFER_BLUE_SIZE = 36178
	public static final int GL_RENDERBUFFER_ALPHA_SIZE = 36179
	public static final int GL_RENDERBUFFER_DEPTH_SIZE = 36180
	public static final int GL_RENDERBUFFER_STENCIL_SIZE = 36181
	public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048
	public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049
	public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050
	public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051
	public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 33296
	public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 33297
	public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 33298
	public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 33299
	public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 33300
	public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 33301
	public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 33302
	public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 33303
	public static final int GL_FRAMEBUFFER_DEFAULT = 33304
	public static final int GL_INDEX = 33314
	public static final int GL_COLOR_ATTACHMENT0 = 36064
	public static final int GL_COLOR_ATTACHMENT1 = 36065
	public static final int GL_COLOR_ATTACHMENT2 = 36066
	public static final int GL_COLOR_ATTACHMENT3 = 36067
	public static final int GL_COLOR_ATTACHMENT4 = 36068
	public static final int GL_COLOR_ATTACHMENT5 = 36069
	public static final int GL_COLOR_ATTACHMENT6 = 36070
	public static final int GL_COLOR_ATTACHMENT7 = 36071
	public static final int GL_COLOR_ATTACHMENT8 = 36072
	public static final int GL_COLOR_ATTACHMENT9 = 36073
	public static final int GL_COLOR_ATTACHMENT10 = 36074
	public static final int GL_COLOR_ATTACHMENT11 = 36075
	public static final int GL_COLOR_ATTACHMENT12 = 36076
	public static final int GL_COLOR_ATTACHMENT13 = 36077
	public static final int GL_COLOR_ATTACHMENT14 = 36078
	public static final int GL_COLOR_ATTACHMENT15 = 36079
	public static final int GL_DEPTH_ATTACHMENT = 36096
	public static final int GL_STENCIL_ATTACHMENT = 36128
	public static final int GL_DEPTH_STENCIL_ATTACHMENT = 33306
	public static final int GL_FRAMEBUFFER_COMPLETE = 36053
	public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054
	public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055
	public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 36059
	public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 36060
	public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061
	public static final int GL_FRAMEBUFFER_UNDEFINED = 33305
	public static final int GL_FRAMEBUFFER_BINDING = 36006
	public static final int GL_RENDERBUFFER_BINDING = 36007
	public static final int GL_MAX_COLOR_ATTACHMENTS = 36063
	public static final int GL_MAX_RENDERBUFFER_SIZE = 34024
	public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286
	public static final int GL_HALF_FLOAT = 5131
	public static final int GL_RENDERBUFFER_SAMPLES = 36011
	public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 36182
	public static final int GL_MAX_SAMPLES = 36183
	public static final int GL_DRAW_FRAMEBUFFER_BINDING = 36006
	public static final int GL_READ_FRAMEBUFFER_BINDING = 36010
	public static final int GL_RGBA_INTEGER_MODE = 36254
	public static final int GL_RGBA32UI = 36208
	public static final int GL_RGB32UI = 36209
	public static final int GL_ALPHA32UI = 36210
	public static final int GL_RGBA16UI = 36214
	public static final int GL_RGB16UI = 36215
	public static final int GL_ALPHA16UI = 36216
	public static final int GL_RGBA8UI = 36220
	public static final int GL_RGB8UI = 36221
	public static final int GL_ALPHA8UI = 36222
	public static final int GL_RGBA32I = 36226
	public static final int GL_RGB32I = 36227
	public static final int GL_ALPHA32I = 36228
	public static final int GL_RGBA16I = 36232
	public static final int GL_RGB16I = 36233
	public static final int GL_ALPHA16I = 36234
	public static final int GL_RGBA8I = 36238
	public static final int GL_RGB8I = 36239
	public static final int GL_ALPHA8I = 36240
	public static final int GL_RED_INTEGER = 36244
	public static final int GL_GREEN_INTEGER = 36245
	public static final int GL_BLUE_INTEGER = 36246
	public static final int GL_ALPHA_INTEGER = 36247
	public static final int GL_RGB_INTEGER = 36248
	public static final int GL_RGBA_INTEGER = 36249
	public static final int GL_BGR_INTEGER = 36250
	public static final int GL_BGRA_INTEGER = 36251
	public static final int GL_TEXTURE_1D_ARRAY = 35864
	public static final int GL_TEXTURE_2D_ARRAY = 35866
	public static final int GL_PROXY_TEXTURE_2D_ARRAY = 35867
	public static final int GL_PROXY_TEXTURE_1D_ARRAY = 35865
	public static final int GL_TEXTURE_BINDING_1D_ARRAY = 35868
	public static final int GL_TEXTURE_BINDING_2D_ARRAY = 35869
	public static final int GL_MAX_ARRAY_TEXTURE_LAYERS = 35071
	public static final int GL_COMPARE_REF_DEPTH_TO_TEXTURE = 34894
	public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052
	public static final int GL_SAMPLER_1D_ARRAY = 36288
	public static final int GL_SAMPLER_2D_ARRAY = 36289
	public static final int GL_SAMPLER_1D_ARRAY_SHADOW = 36291
	public static final int GL_SAMPLER_2D_ARRAY_SHADOW = 36292
	public static final int GL_DEPTH_STENCIL = 34041
	public static final int GL_UNSIGNED_INT_24_8 = 34042
	public static final int GL_DEPTH24_STENCIL8 = 35056
	public static final int GL_TEXTURE_STENCIL_SIZE = 35057
	public static final int GL_COMPRESSED_RED_RGTC1 = 36283
	public static final int GL_COMPRESSED_SIGNED_RED_RGTC1 = 36284
	public static final int GL_COMPRESSED_RG_RGTC2 = 36285
	public static final int GL_COMPRESSED_SIGNED_RG_RGTC2 = 36286
	public static final int GL_R8 = 33321
	public static final int GL_R16 = 33322
	public static final int GL_RG8 = 33323
	public static final int GL_RG16 = 33324
	public static final int GL_R16F = 33325
	public static final int GL_R32F = 33326
	public static final int GL_RG16F = 33327
	public static final int GL_RG32F = 33328
	public static final int GL_R8I = 33329
	public static final int GL_R8UI = 33330
	public static final int GL_R16I = 33331
	public static final int GL_R16UI = 33332
	public static final int GL_R32I = 33333
	public static final int GL_R32UI = 33334
	public static final int GL_RG8I = 33335
	public static final int GL_RG8UI = 33336
	public static final int GL_RG16I = 33337
	public static final int GL_RG16UI = 33338
	public static final int GL_RG32I = 33339
	public static final int GL_RG32UI = 33340
	public static final int GL_RG = 33319
	public static final int GL_RG_INTEGER = 33320
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 35982
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START = 35972
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE = 35973
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING = 35983
	public static final int GL_INTERLEAVED_ATTRIBS = 35980
	public static final int GL_SEPARATE_ATTRIBS = 35981
	public static final int GL_PRIMITIVES_GENERATED = 35975
	public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = 35976
	public static final int GL_RASTERIZER_DISCARD = 35977
	public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 35978
	public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS = 35979
	public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS = 35968
	public static final int GL_TRANSFORM_FEEDBACK_VARYINGS = 35971
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE = 35967
	public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = 35958
	public static final int GL_VERTEX_ARRAY_BINDING = 34229
	public static final int GL_FRAMEBUFFER_SRGB = 36281
	public static final int GL_FRAMEBUFFER_SRGB_CAPABLE = 36282
	public static final int GL_FLOAT_MAT2x3 = 35685
	public static final int GL_FLOAT_MAT2x4 = 35686
	public static final int GL_FLOAT_MAT3x2 = 35687
	public static final int GL_FLOAT_MAT3x4 = 35688
	public static final int GL_FLOAT_MAT4x2 = 35689
	public static final int GL_FLOAT_MAT4x3 = 35690
	public static final int GL_PIXEL_PACK_BUFFER = 35051
	public static final int GL_PIXEL_UNPACK_BUFFER = 35052
	public static final int GL_PIXEL_PACK_BUFFER_BINDING = 35053
	public static final int GL_PIXEL_UNPACK_BUFFER_BINDING = 35055
	public static final int GL_SRGB = 35904
	public static final int GL_SRGB8 = 35905
	public static final int GL_SRGB_ALPHA = 35906
	public static final int GL_SRGB8_ALPHA8 = 35907
	public static final int GL_SLUMINANCE_ALPHA = 35908
	public static final int GL_SLUMINANCE8_ALPHA8 = 35909
	public static final int GL_SLUMINANCE = 35910
	public static final int GL_SLUMINANCE8 = 35911
	public static final int GL_COMPRESSED_SRGB = 35912
	public static final int GL_COMPRESSED_SRGB_ALPHA = 35913
	public static final int GL_COMPRESSED_SLUMINANCE = 35914
	public static final int GL_COMPRESSED_SLUMINANCE_ALPHA = 35915
	public static final int GL_CURRENT_RASTER_SECONDARY_COLOR = 33887
	public static final int GL_SHADING_LANGUAGE_VERSION = 35724
	public static final int GL_CURRENT_PROGRAM = 35725
	public static final int GL_SHADER_TYPE = 35663
	public static final int GL_DELETE_STATUS = 35712
	public static final int GL_COMPILE_STATUS = 35713
	public static final int GL_LINK_STATUS = 35714
	public static final int GL_VALIDATE_STATUS = 35715
	public static final int GL_INFO_LOG_LENGTH = 35716
	public static final int GL_ATTACHED_SHADERS = 35717
	public static final int GL_ACTIVE_UNIFORMS = 35718
	public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719
	public static final int GL_ACTIVE_ATTRIBUTES = 35721
	public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722
	public static final int GL_SHADER_SOURCE_LENGTH = 35720
	public static final int GL_SHADER_OBJECT = 35656
	public static final int GL_FLOAT_VEC2 = 35664
	public static final int GL_FLOAT_VEC3 = 35665
	public static final int GL_FLOAT_VEC4 = 35666
	public static final int GL_INT_VEC2 = 35667
	public static final int GL_INT_VEC3 = 35668
	public static final int GL_INT_VEC4 = 35669
	public static final int GL_BOOL = 35670
	public static final int GL_BOOL_VEC2 = 35671
	public static final int GL_BOOL_VEC3 = 35672
	public static final int GL_BOOL_VEC4 = 35673
	public static final int GL_FLOAT_MAT2 = 35674
	public static final int GL_FLOAT_MAT3 = 35675
	public static final int GL_FLOAT_MAT4 = 35676
	public static final int GL_SAMPLER_1D = 35677
	public static final int GL_SAMPLER_2D = 35678
	public static final int GL_SAMPLER_3D = 35679
	public static final int GL_SAMPLER_CUBE = 35680
	public static final int GL_SAMPLER_1D_SHADOW = 35681
	public static final int GL_SAMPLER_2D_SHADOW = 35682
	public static final int GL_VERTEX_SHADER = 35633
	public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 35658
	public static final int GL_MAX_VARYING_FLOATS = 35659
	public static final int GL_MAX_VERTEX_ATTRIBS = 34921
	public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930
	public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660
	public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661
	public static final int GL_MAX_TEXTURE_COORDS = 34929
	public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370
	public static final int GL_VERTEX_PROGRAM_TWO_SIDE = 34371
	public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338
	public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339
	public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340
	public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341
	public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922
	public static final int GL_CURRENT_VERTEX_ATTRIB = 34342
	public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373
	public static final int GL_FRAGMENT_SHADER = 35632
	public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 35657
	public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 35723
	public static final int GL_MAX_DRAW_BUFFERS = 34852
	public static final int GL_DRAW_BUFFER0 = 34853
	public static final int GL_DRAW_BUFFER1 = 34854
	public static final int GL_DRAW_BUFFER2 = 34855
	public static final int GL_DRAW_BUFFER3 = 34856
	public static final int GL_DRAW_BUFFER4 = 34857
	public static final int GL_DRAW_BUFFER5 = 34858
	public static final int GL_DRAW_BUFFER6 = 34859
	public static final int GL_DRAW_BUFFER7 = 34860
	public static final int GL_DRAW_BUFFER8 = 34861
	public static final int GL_DRAW_BUFFER9 = 34862
	public static final int GL_DRAW_BUFFER10 = 34863
	public static final int GL_DRAW_BUFFER11 = 34864
	public static final int GL_DRAW_BUFFER12 = 34865
	public static final int GL_DRAW_BUFFER13 = 34866
	public static final int GL_DRAW_BUFFER14 = 34867
	public static final int GL_DRAW_BUFFER15 = 34868
	public static final int GL_POINT_SPRITE = 34913
	public static final int GL_COORD_REPLACE = 34914
	public static final int GL_POINT_SPRITE_COORD_ORIGIN = 36000
	public static final int GL_LOWER_LEFT = 36001
	public static final int GL_UPPER_LEFT = 36002
	public static final int GL_STENCIL_BACK_FUNC = 34816
	public static final int GL_STENCIL_BACK_FAIL = 34817
	public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818
	public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819
	public static final int GL_STENCIL_BACK_REF = 36003
	public static final int GL_STENCIL_BACK_VALUE_MASK = 36004
	public static final int GL_STENCIL_BACK_WRITEMASK = 36005
	public static final int GL_BLEND_EQUATION_RGB = 32777
	public static final int GL_BLEND_EQUATION_ALPHA = 34877
	public static final int GL_ARRAY_BUFFER = 34962
	public static final int GL_ELEMENT_ARRAY_BUFFER = 34963
	public static final int GL_ARRAY_BUFFER_BINDING = 34964
	public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965
	public static final int GL_VERTEX_ARRAY_BUFFER_BINDING = 34966
	public static final int GL_NORMAL_ARRAY_BUFFER_BINDING = 34967
	public static final int GL_COLOR_ARRAY_BUFFER_BINDING = 34968
	public static final int GL_INDEX_ARRAY_BUFFER_BINDING = 34969
	public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING = 34970
	public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING = 34971
	public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING = 34972
	public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING = 34973
	public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING = 34974
	public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975
	public static final int GL_STREAM_DRAW = 35040
	public static final int GL_STREAM_READ = 35041
	public static final int GL_STREAM_COPY = 35042
	public static final int GL_STATIC_DRAW = 35044
	public static final int GL_STATIC_READ = 35045
	public static final int GL_STATIC_COPY = 35046
	public static final int GL_DYNAMIC_DRAW = 35048
	public static final int GL_DYNAMIC_READ = 35049
	public static final int GL_DYNAMIC_COPY = 35050
	public static final int GL_READ_ONLY = 35000
	public static final int GL_WRITE_ONLY = 35001
	public static final int GL_READ_WRITE = 35002
	public static final int GL_BUFFER_SIZE = 34660
	public static final int GL_BUFFER_USAGE = 34661
	public static final int GL_BUFFER_ACCESS = 35003
	public static final int GL_BUFFER_MAPPED = 35004
	public static final int GL_BUFFER_MAP_POINTER = 35005
	public static final int GL_FOG_COORD_SRC = 33872
	public static final int GL_FOG_COORD = 33873
	public static final int GL_CURRENT_FOG_COORD = 33875
	public static final int GL_FOG_COORD_ARRAY_TYPE = 33876
	public static final int GL_FOG_COORD_ARRAY_STRIDE = 33877
	public static final int GL_FOG_COORD_ARRAY_POINTER = 33878
	public static final int GL_FOG_COORD_ARRAY = 33879
	public static final int GL_FOG_COORD_ARRAY_BUFFER_BINDING = 34973
	public static final int GL_SRC0_RGB = 34176
	public static final int GL_SRC1_RGB = 34177
	public static final int GL_SRC2_RGB = 34178
	public static final int GL_SRC0_ALPHA = 34184
	public static final int GL_SRC1_ALPHA = 34185
	public static final int GL_SRC2_ALPHA = 34186
	public static final int GL_SAMPLES_PASSED = 35092
	public static final int GL_QUERY_COUNTER_BITS = 34916
	public static final int GL_CURRENT_QUERY = 34917
	public static final int GL_QUERY_RESULT = 34918
	public static final int GL_QUERY_RESULT_AVAILABLE = 34919
	public static final int GL_GENERATE_MIPMAP = 33169
	public static final int GL_GENERATE_MIPMAP_HINT = 33170
	public static final int GL_DEPTH_COMPONENT16 = 33189
	public static final int GL_DEPTH_COMPONENT24 = 33190
	public static final int GL_DEPTH_COMPONENT32 = 33191
	public static final int GL_TEXTURE_DEPTH_SIZE = 34890
	public static final int GL_DEPTH_TEXTURE_MODE = 34891
	public static final int GL_TEXTURE_COMPARE_MODE = 34892
	public static final int GL_TEXTURE_COMPARE_FUNC = 34893
	public static final int GL_COMPARE_R_TO_TEXTURE = 34894
	public static final int GL_FOG_COORDINATE_SOURCE = 33872
	public static final int GL_FOG_COORDINATE = 33873
	public static final int GL_FRAGMENT_DEPTH = 33874
	public static final int GL_CURRENT_FOG_COORDINATE = 33875
	public static final int GL_FOG_COORDINATE_ARRAY_TYPE = 33876
	public static final int GL_FOG_COORDINATE_ARRAY_STRIDE = 33877
	public static final int GL_FOG_COORDINATE_ARRAY_POINTER = 33878
	public static final int GL_FOG_COORDINATE_ARRAY = 33879
	public static final int GL_POINT_SIZE_MIN = 33062
	public static final int GL_POINT_SIZE_MAX = 33063
	public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064
	public static final int GL_POINT_DISTANCE_ATTENUATION = 33065
	public static final int GL_COLOR_SUM = 33880
	public static final int GL_CURRENT_SECONDARY_COLOR = 33881
	public static final int GL_SECONDARY_COLOR_ARRAY_SIZE = 33882
	public static final int GL_SECONDARY_COLOR_ARRAY_TYPE = 33883
	public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE = 33884
	public static final int GL_SECONDARY_COLOR_ARRAY_POINTER = 33885
	public static final int GL_SECONDARY_COLOR_ARRAY = 33886
	public static final int GL_BLEND_DST_RGB = 32968
	public static final int GL_BLEND_SRC_RGB = 32969
	public static final int GL_BLEND_DST_ALPHA = 32970
	public static final int GL_BLEND_SRC_ALPHA = 32971
	public static final int GL_INCR_WRAP = 34055
	public static final int GL_DECR_WRAP = 34056
	public static final int GL_TEXTURE_FILTER_CONTROL = 34048
	public static final int GL_TEXTURE_LOD_BIAS = 34049
	public static final int GL_MAX_TEXTURE_LOD_BIAS = 34045
	public static final int GL_MIRRORED_REPEAT = 33648
	public static final int GL_BLEND_COLOR = 32773
	public static final int GL_BLEND_EQUATION = 32777
	public static final int GL_FUNC_ADD = 32774
	public static final int GL_FUNC_SUBTRACT = 32778
	public static final int GL_FUNC_REVERSE_SUBTRACT = 32779
	public static final int GL_MIN = 32775
	public static final int GL_MAX = 32776
	public static final int GL_TEXTURE0 = 33984
	public static final int GL_TEXTURE1 = 33985
	public static final int GL_TEXTURE2 = 33986
	public static final int GL_TEXTURE3 = 33987
	public static final int GL_TEXTURE4 = 33988
	public static final int GL_TEXTURE5 = 33989
	public static final int GL_TEXTURE6 = 33990
	public static final int GL_TEXTURE7 = 33991
	public static final int GL_TEXTURE8 = 33992
	public static final int GL_TEXTURE9 = 33993
	public static final int GL_TEXTURE10 = 33994
	public static final int GL_TEXTURE11 = 33995
	public static final int GL_TEXTURE12 = 33996
	public static final int GL_TEXTURE13 = 33997
	public static final int GL_TEXTURE14 = 33998
	public static final int GL_TEXTURE15 = 33999
	public static final int GL_TEXTURE16 = 34000
	public static final int GL_TEXTURE17 = 34001
	public static final int GL_TEXTURE18 = 34002
	public static final int GL_TEXTURE19 = 34003
	public static final int GL_TEXTURE20 = 34004
	public static final int GL_TEXTURE21 = 34005
	public static final int GL_TEXTURE22 = 34006
	public static final int GL_TEXTURE23 = 34007
	public static final int GL_TEXTURE24 = 34008
	public static final int GL_TEXTURE25 = 34009
	public static final int GL_TEXTURE26 = 34010
	public static final int GL_TEXTURE27 = 34011
	public static final int GL_TEXTURE28 = 34012
	public static final int GL_TEXTURE29 = 34013
	public static final int GL_TEXTURE30 = 34014
	public static final int GL_TEXTURE31 = 34015
	public static final int GL_ACTIVE_TEXTURE = 34016
	public static final int GL_CLIENT_ACTIVE_TEXTURE = 34017
	public static final int GL_MAX_TEXTURE_UNITS = 34018
	public static final int GL_NORMAL_MAP = 34065
	public static final int GL_REFLECTION_MAP = 34066
	public static final int GL_TEXTURE_CUBE_MAP = 34067
	public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068
	public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069
	public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070
	public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071
	public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072
	public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073
	public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074
	public static final int GL_PROXY_TEXTURE_CUBE_MAP = 34075
	public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076
	public static final int GL_COMPRESSED_ALPHA = 34025
	public static final int GL_COMPRESSED_LUMINANCE = 34026
	public static final int GL_COMPRESSED_LUMINANCE_ALPHA = 34027
	public static final int GL_COMPRESSED_INTENSITY = 34028
	public static final int GL_COMPRESSED_RGB = 34029
	public static final int GL_COMPRESSED_RGBA = 34030
	public static final int GL_TEXTURE_COMPRESSION_HINT = 34031
	public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 34464
	public static final int GL_TEXTURE_COMPRESSED = 34465
	public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466
	public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467
	public static final int GL_MULTISAMPLE = 32925
	public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926
	public static final int GL_SAMPLE_ALPHA_TO_ONE = 32927
	public static final int GL_SAMPLE_COVERAGE = 32928
	public static final int GL_SAMPLE_BUFFERS = 32936
	public static final int GL_SAMPLES = 32937
	public static final int GL_SAMPLE_COVERAGE_VALUE = 32938
	public static final int GL_SAMPLE_COVERAGE_INVERT = 32939
	public static final int GL_MULTISAMPLE_BIT = 536870912
	public static final int GL_TRANSPOSE_MODELVIEW_MATRIX = 34019
	public static final int GL_TRANSPOSE_PROJECTION_MATRIX = 34020
	public static final int GL_TRANSPOSE_TEXTURE_MATRIX = 34021
	public static final int GL_TRANSPOSE_COLOR_MATRIX = 34022
	public static final int GL_COMBINE = 34160
	public static final int GL_COMBINE_RGB = 34161
	public static final int GL_COMBINE_ALPHA = 34162
	public static final int GL_SOURCE0_RGB = 34176
	public static final int GL_SOURCE1_RGB = 34177
	public static final int GL_SOURCE2_RGB = 34178
	public static final int GL_SOURCE0_ALPHA = 34184
	public static final int GL_SOURCE1_ALPHA = 34185
	public static final int GL_SOURCE2_ALPHA = 34186
	public static final int GL_OPERAND0_RGB = 34192
	public static final int GL_OPERAND1_RGB = 34193
	public static final int GL_OPERAND2_RGB = 34194
	public static final int GL_OPERAND0_ALPHA = 34200
	public static final int GL_OPERAND1_ALPHA = 34201
	public static final int GL_OPERAND2_ALPHA = 34202
	public static final int GL_RGB_SCALE = 34163
	public static final int GL_ADD_SIGNED = 34164
	public static final int GL_INTERPOLATE = 34165
	public static final int GL_SUBTRACT = 34023
	public static final int GL_CONSTANT = 34166
	public static final int GL_PRIMARY_COLOR = 34167
	public static final int GL_PREVIOUS = 34168
	public static final int GL_DOT3_RGB = 34478
	public static final int GL_DOT3_RGBA = 34479
	public static final int GL_CLAMP_TO_BORDER = 33069
	public static final int GL_TEXTURE_BINDING_3D = 32874
	public static final int GL_PACK_SKIP_IMAGES = 32875
	public static final int GL_PACK_IMAGE_HEIGHT = 32876
	public static final int GL_UNPACK_SKIP_IMAGES = 32877
	public static final int GL_UNPACK_IMAGE_HEIGHT = 32878
	public static final int GL_TEXTURE_3D = 32879
	public static final int GL_PROXY_TEXTURE_3D = 32880
	public static final int GL_TEXTURE_DEPTH = 32881
	public static final int GL_TEXTURE_WRAP_R = 32882
	public static final int GL_MAX_3D_TEXTURE_SIZE = 32883
	public static final int GL_BGR = 32992
	public static final int GL_BGRA = 32993
	public static final int GL_UNSIGNED_BYTE_3_3_2 = 32818
	public static final int GL_UNSIGNED_BYTE_2_3_3_REV = 33634
	public static final int GL_UNSIGNED_SHORT_5_6_5 = 33635
	public static final int GL_UNSIGNED_SHORT_5_6_5_REV = 33636
	public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 32819
	public static final int GL_UNSIGNED_SHORT_4_4_4_4_REV = 33637
	public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 32820
	public static final int GL_UNSIGNED_SHORT_1_5_5_5_REV = 33638
	public static final int GL_UNSIGNED_INT_8_8_8_8 = 32821
	public static final int GL_UNSIGNED_INT_8_8_8_8_REV = 33639
	public static final int GL_UNSIGNED_INT_10_10_10_2 = 32822
	public static final int GL_UNSIGNED_INT_2_10_10_10_REV = 33640
	public static final int GL_RESCALE_NORMAL = 32826
	public static final int GL_LIGHT_MODEL_COLOR_CONTROL = 33272
	public static final int GL_SINGLE_COLOR = 33273
	public static final int GL_SEPARATE_SPECULAR_COLOR = 33274
	public static final int GL_CLAMP_TO_EDGE = 33071
	public static final int GL_TEXTURE_MIN_LOD = 33082
	public static final int GL_TEXTURE_MAX_LOD = 33083
	public static final int GL_TEXTURE_BASE_LEVEL = 33084
	public static final int GL_TEXTURE_MAX_LEVEL = 33085
	public static final int GL_MAX_ELEMENTS_VERTICES = 33000
	public static final int GL_MAX_ELEMENTS_INDICES = 33001
	public static final int GL_ALIASED_POINT_SIZE_RANGE = 33901
	public static final int GL_ALIASED_LINE_WIDTH_RANGE = 33902
	public static final int GL_SMOOTH_POINT_SIZE_RANGE = 2834
	public static final int GL_SMOOTH_POINT_SIZE_GRANULARITY = 2835
	public static final int GL_SMOOTH_LINE_WIDTH_RANGE = 2850
	public static final int GL_SMOOTH_LINE_WIDTH_GRANULARITY = 2851
	public static final int GL_ACCUM = 256
	public static final int GL_LOAD = 257
	public static final int GL_RETURN = 258
	public static final int GL_MULT = 259
	public static final int GL_ADD = 260
	public static final int GL_NEVER = 512
	public static final int GL_LESS = 513
	public static final int GL_EQUAL = 514
	public static final int GL_LEQUAL = 515
	public static final int GL_GREATER = 516
	public static final int GL_NOTEQUAL = 517
	public static final int GL_GEQUAL = 518
	public static final int GL_ALWAYS = 519
	public static final int GL_CURRENT_BIT = 1
	public static final int GL_POINT_BIT = 2
	public static final int GL_LINE_BIT = 4
	public static final int GL_POLYGON_BIT = 8
	public static final int GL_POLYGON_STIPPLE_BIT = 16
	public static final int GL_PIXEL_MODE_BIT = 32
	public static final int GL_LIGHTING_BIT = 64
	public static final int GL_FOG_BIT = 128
	public static final int GL_DEPTH_BUFFER_BIT = 256
	public static final int GL_ACCUM_BUFFER_BIT = 512
	public static final int GL_STENCIL_BUFFER_BIT = 1024
	public static final int GL_VIEWPORT_BIT = 2048
	public static final int GL_TRANSFORM_BIT = 4096
	public static final int GL_ENABLE_BIT = 8192
	public static final int GL_COLOR_BUFFER_BIT = 16384
	public static final int GL_HINT_BIT = 32768
	public static final int GL_EVAL_BIT = 65536
	public static final int GL_LIST_BIT = 131072
	public static final int GL_TEXTURE_BIT = 262144
	public static final int GL_SCISSOR_BIT = 524288
	public static final int GL_ALL_ATTRIB_BITS = 1048575
	public static final int GL_POINTS = 0
	public static final int GL_LINES = 1
	public static final int GL_LINE_LOOP = 2
	public static final int GL_LINE_STRIP = 3
	public static final int GL_TRIANGLES = 4
	public static final int GL_TRIANGLE_STRIP = 5
	public static final int GL_TRIANGLE_FAN = 6
	public static final int GL_QUADS = 7
	public static final int GL_QUAD_STRIP = 8
	public static final int GL_POLYGON = 9
	public static final int GL_ZERO = 0
	public static final int GL_ONE = 1
	public static final int GL_SRC_COLOR = 768
	public static final int GL_ONE_MINUS_SRC_COLOR = 769
	public static final int GL_SRC_ALPHA = 770
	public static final int GL_ONE_MINUS_SRC_ALPHA = 771
	public static final int GL_DST_ALPHA = 772
	public static final int GL_ONE_MINUS_DST_ALPHA = 773
	public static final int GL_DST_COLOR = 774
	public static final int GL_ONE_MINUS_DST_COLOR = 775
	public static final int GL_SRC_ALPHA_SATURATE = 776
	public static final int GL_CONSTANT_COLOR = 32769
	public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770
	public static final int GL_CONSTANT_ALPHA = 32771
	public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772
	public static final int GL_TRUE = 1
	public static final int GL_FALSE = 0
	public static final int GL_CLIP_PLANE0 = 12288
	public static final int GL_CLIP_PLANE1 = 12289
	public static final int GL_CLIP_PLANE2 = 12290
	public static final int GL_CLIP_PLANE3 = 12291
	public static final int GL_CLIP_PLANE4 = 12292
	public static final int GL_CLIP_PLANE5 = 12293
	public static final int GL_BYTE = 5120
	public static final int GL_UNSIGNED_BYTE = 5121
	public static final int GL_SHORT = 5122
	public static final int GL_UNSIGNED_SHORT = 5123
	public static final int GL_INT = 5124
	public static final int GL_UNSIGNED_INT = 5125
	public static final int GL_FLOAT = 5126
	public static final int GL_2_BYTES = 5127
	public static final int GL_3_BYTES = 5128
	public static final int GL_4_BYTES = 5129
	public static final int GL_DOUBLE = 5130
	public static final int GL_NONE = 0
	public static final int GL_FRONT_LEFT = 1024
	public static final int GL_FRONT_RIGHT = 1025
	public static final int GL_BACK_LEFT = 1026
	public static final int GL_BACK_RIGHT = 1027
	public static final int GL_FRONT = 1028
	public static final int GL_BACK = 1029
	public static final int GL_LEFT = 1030
	public static final int GL_RIGHT = 1031
	public static final int GL_FRONT_AND_BACK = 1032
	public static final int GL_AUX0 = 1033
	public static final int GL_AUX1 = 1034
	public static final int GL_AUX2 = 1035
	public static final int GL_AUX3 = 1036
	public static final int GL_NO_ERROR = 0
	public static final int GL_INVALID_ENUM = 1280
	public static final int GL_INVALID_VALUE = 1281
	public static final int GL_INVALID_OPERATION = 1282
	public static final int GL_STACK_OVERFLOW = 1283
	public static final int GL_STACK_UNDERFLOW = 1284
	public static final int GL_OUT_OF_MEMORY = 1285
	public static final int GL_2D = 1536
	public static final int GL_3D = 1537
	public static final int GL_3D_COLOR = 1538
	public static final int GL_3D_COLOR_TEXTURE = 1539
	public static final int GL_4D_COLOR_TEXTURE = 1540
	public static final int GL_PASS_THROUGH_TOKEN = 1792
	public static final int GL_POINT_TOKEN = 1793
	public static final int GL_LINE_TOKEN = 1794
	public static final int GL_POLYGON_TOKEN = 1795
	public static final int GL_BITMAP_TOKEN = 1796
	public static final int GL_DRAW_PIXEL_TOKEN = 1797
	public static final int GL_COPY_PIXEL_TOKEN = 1798
	public static final int GL_LINE_RESET_TOKEN = 1799
	public static final int GL_EXP = 2048
	public static final int GL_EXP2 = 2049
	public static final int GL_CW = 2304
	public static final int GL_CCW = 2305
	public static final int GL_COEFF = 2560
	public static final int GL_ORDER = 2561
	public static final int GL_DOMAIN = 2562
	public static final int GL_CURRENT_COLOR = 2816
	public static final int GL_CURRENT_INDEX = 2817
	public static final int GL_CURRENT_NORMAL = 2818
	public static final int GL_CURRENT_TEXTURE_COORDS = 2819
	public static final int GL_CURRENT_RASTER_COLOR = 2820
	public static final int GL_CURRENT_RASTER_INDEX = 2821
	public static final int GL_CURRENT_RASTER_TEXTURE_COORDS = 2822
	public static final int GL_CURRENT_RASTER_POSITION = 2823
	public static final int GL_CURRENT_RASTER_POSITION_VALID = 2824
	public static final int GL_CURRENT_RASTER_DISTANCE = 2825
	public static final int GL_POINT_SMOOTH = 2832
	public static final int GL_POINT_SIZE = 2833
	public static final int GL_POINT_SIZE_RANGE = 2834
	public static final int GL_POINT_SIZE_GRANULARITY = 2835
	public static final int GL_LINE_SMOOTH = 2848
	public static final int GL_LINE_WIDTH = 2849
	public static final int GL_LINE_WIDTH_RANGE = 2850
	public static final int GL_LINE_WIDTH_GRANULARITY = 2851
	public static final int GL_LINE_STIPPLE = 2852
	public static final int GL_LINE_STIPPLE_PATTERN = 2853
	public static final int GL_LINE_STIPPLE_REPEAT = 2854
	public static final int GL_LIST_MODE = 2864
	public static final int GL_MAX_LIST_NESTING = 2865
	public static final int GL_LIST_BASE = 2866
	public static final int GL_LIST_INDEX = 2867
	public static final int GL_POLYGON_MODE = 2880
	public static final int GL_POLYGON_SMOOTH = 2881
	public static final int GL_POLYGON_STIPPLE = 2882
	public static final int GL_EDGE_FLAG = 2883
	public static final int GL_CULL_FACE = 2884
	public static final int GL_CULL_FACE_MODE = 2885
	public static final int GL_FRONT_FACE = 2886
	public static final int GL_LIGHTING = 2896
	public static final int GL_LIGHT_MODEL_LOCAL_VIEWER = 2897
	public static final int GL_LIGHT_MODEL_TWO_SIDE = 2898
	public static final int GL_LIGHT_MODEL_AMBIENT = 2899
	public static final int GL_SHADE_MODEL = 2900
	public static final int GL_COLOR_MATERIAL_FACE = 2901
	public static final int GL_COLOR_MATERIAL_PARAMETER = 2902
	public static final int GL_COLOR_MATERIAL = 2903
	public static final int GL_FOG = 2912
	public static final int GL_FOG_INDEX = 2913
	public static final int GL_FOG_DENSITY = 2914
	public static final int GL_FOG_START = 2915
	public static final int GL_FOG_END = 2916
	public static final int GL_FOG_MODE = 2917
	public static final int GL_FOG_COLOR = 2918
	public static final int GL_DEPTH_RANGE = 2928
	public static final int GL_DEPTH_TEST = 2929
	public static final int GL_DEPTH_WRITEMASK = 2930
	public static final int GL_DEPTH_CLEAR_VALUE = 2931
	public static final int GL_DEPTH_FUNC = 2932
	public static final int GL_ACCUM_CLEAR_VALUE = 2944
	public static final int GL_STENCIL_TEST = 2960
	public static final int GL_STENCIL_CLEAR_VALUE = 2961
	public static final int GL_STENCIL_FUNC = 2962
	public static final int GL_STENCIL_VALUE_MASK = 2963
	public static final int GL_STENCIL_FAIL = 2964
	public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965
	public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966
	public static final int GL_STENCIL_REF = 2967
	public static final int GL_STENCIL_WRITEMASK = 2968
	public static final int GL_MATRIX_MODE = 2976
	public static final int GL_NORMALIZE = 2977
	public static final int GL_VIEWPORT = 2978
	public static final int GL_MODELVIEW_STACK_DEPTH = 2979
	public static final int GL_PROJECTION_STACK_DEPTH = 2980
	public static final int GL_TEXTURE_STACK_DEPTH = 2981
	public static final int GL_MODELVIEW_MATRIX = 2982
	public static final int GL_PROJECTION_MATRIX = 2983
	public static final int GL_TEXTURE_MATRIX = 2984
	public static final int GL_ATTRIB_STACK_DEPTH = 2992
	public static final int GL_CLIENT_ATTRIB_STACK_DEPTH = 2993
	public static final int GL_ALPHA_TEST = 3008
	public static final int GL_ALPHA_TEST_FUNC = 3009
	public static final int GL_ALPHA_TEST_REF = 3010
	public static final int GL_DITHER = 3024
	public static final int GL_BLEND_DST = 3040
	public static final int GL_BLEND_SRC = 3041
	public static final int GL_BLEND = 3042
	public static final int GL_LOGIC_OP_MODE = 3056
	public static final int GL_INDEX_LOGIC_OP = 3057
	public static final int GL_COLOR_LOGIC_OP = 3058
	public static final int GL_AUX_BUFFERS = 3072
	public static final int GL_DRAW_BUFFER = 3073
	public static final int GL_READ_BUFFER = 3074
	public static final int GL_SCISSOR_BOX = 3088
	public static final int GL_SCISSOR_TEST = 3089
	public static final int GL_INDEX_CLEAR_VALUE = 3104
	public static final int GL_INDEX_WRITEMASK = 3105
	public static final int GL_COLOR_CLEAR_VALUE = 3106
	public static final int GL_COLOR_WRITEMASK = 3107
	public static final int GL_INDEX_MODE = 3120
	public static final int GL_RGBA_MODE = 3121
	public static final int GL_DOUBLEBUFFER = 3122
	public static final int GL_STEREO = 3123
	public static final int GL_RENDER_MODE = 3136
	public static final int GL_PERSPECTIVE_CORRECTION_HINT = 3152
	public static final int GL_POINT_SMOOTH_HINT = 3153
	public static final int GL_LINE_SMOOTH_HINT = 3154
	public static final int GL_POLYGON_SMOOTH_HINT = 3155
	public static final int GL_FOG_HINT = 3156
	public static final int GL_TEXTURE_GEN_S = 3168
	public static final int GL_TEXTURE_GEN_T = 3169
	public static final int GL_TEXTURE_GEN_R = 3170
	public static final int GL_TEXTURE_GEN_Q = 3171
	public static final int GL_PIXEL_MAP_I_TO_I = 3184
	public static final int GL_PIXEL_MAP_S_TO_S = 3185
	public static final int GL_PIXEL_MAP_I_TO_R = 3186
	public static final int GL_PIXEL_MAP_I_TO_G = 3187
	public static final int GL_PIXEL_MAP_I_TO_B = 3188
	public static final int GL_PIXEL_MAP_I_TO_A = 3189
	public static final int GL_PIXEL_MAP_R_TO_R = 3190
	public static final int GL_PIXEL_MAP_G_TO_G = 3191
	public static final int GL_PIXEL_MAP_B_TO_B = 3192
	public static final int GL_PIXEL_MAP_A_TO_A = 3193
	public static final int GL_PIXEL_MAP_I_TO_I_SIZE = 3248
	public static final int GL_PIXEL_MAP_S_TO_S_SIZE = 3249
	public static final int GL_PIXEL_MAP_I_TO_R_SIZE = 3250
	public static final int GL_PIXEL_MAP_I_TO_G_SIZE = 3251
	public static final int GL_PIXEL_MAP_I_TO_B_SIZE = 3252
	public static final int GL_PIXEL_MAP_I_TO_A_SIZE = 3253
	public static final int GL_PIXEL_MAP_R_TO_R_SIZE = 3254
	public static final int GL_PIXEL_MAP_G_TO_G_SIZE = 3255
	public static final int GL_PIXEL_MAP_B_TO_B_SIZE = 3256
	public static final int GL_PIXEL_MAP_A_TO_A_SIZE = 3257
	public static final int GL_UNPACK_SWAP_BYTES = 3312
	public static final int GL_UNPACK_LSB_FIRST = 3313
	public static final int GL_UNPACK_ROW_LENGTH = 3314
	public static final int GL_UNPACK_SKIP_ROWS = 3315
	public static final int GL_UNPACK_SKIP_PIXELS = 3316
	public static final int GL_UNPACK_ALIGNMENT = 3317
	public static final int GL_PACK_SWAP_BYTES = 3328
	public static final int GL_PACK_LSB_FIRST = 3329
	public static final int GL_PACK_ROW_LENGTH = 3330
	public static final int GL_PACK_SKIP_ROWS = 3331
	public static final int GL_PACK_SKIP_PIXELS = 3332
	public static final int GL_PACK_ALIGNMENT = 3333
	public static final int GL_MAP_COLOR = 3344
	public static final int GL_MAP_STENCIL = 3345
	public static final int GL_INDEX_SHIFT = 3346
	public static final int GL_INDEX_OFFSET = 3347
	public static final int GL_RED_SCALE = 3348
	public static final int GL_RED_BIAS = 3349
	public static final int GL_ZOOM_X = 3350
	public static final int GL_ZOOM_Y = 3351
	public static final int GL_GREEN_SCALE = 3352
	public static final int GL_GREEN_BIAS = 3353
	public static final int GL_BLUE_SCALE = 3354
	public static final int GL_BLUE_BIAS = 3355
	public static final int GL_ALPHA_SCALE = 3356
	public static final int GL_ALPHA_BIAS = 3357
	public static final int GL_DEPTH_SCALE = 3358
	public static final int GL_DEPTH_BIAS = 3359
	public static final int GL_MAX_EVAL_ORDER = 3376
	public static final int GL_MAX_LIGHTS = 3377
	public static final int GL_MAX_CLIP_PLANES = 3378
	public static final int GL_MAX_TEXTURE_SIZE = 3379
	public static final int GL_MAX_PIXEL_MAP_TABLE = 3380
	public static final int GL_MAX_ATTRIB_STACK_DEPTH = 3381
	public static final int GL_MAX_MODELVIEW_STACK_DEPTH = 3382
	public static final int GL_MAX_NAME_STACK_DEPTH = 3383
	public static final int GL_MAX_PROJECTION_STACK_DEPTH = 3384
	public static final int GL_MAX_TEXTURE_STACK_DEPTH = 3385
	public static final int GL_MAX_VIEWPORT_DIMS = 3386
	public static final int GL_MAX_CLIENT_ATTRIB_STACK_DEPTH = 3387
	public static final int GL_SUBPIXEL_BITS = 3408
	public static final int GL_INDEX_BITS = 3409
	public static final int GL_RED_BITS = 3410
	public static final int GL_GREEN_BITS = 3411
	public static final int GL_BLUE_BITS = 3412
	public static final int GL_ALPHA_BITS = 3413
	public static final int GL_DEPTH_BITS = 3414
	public static final int GL_STENCIL_BITS = 3415
	public static final int GL_ACCUM_RED_BITS = 3416
	public static final int GL_ACCUM_GREEN_BITS = 3417
	public static final int GL_ACCUM_BLUE_BITS = 3418
	public static final int GL_ACCUM_ALPHA_BITS = 3419
	public static final int GL_NAME_STACK_DEPTH = 3440
	public static final int GL_AUTO_NORMAL = 3456
	public static final int GL_MAP1_COLOR_4 = 3472
	public static final int GL_MAP1_INDEX = 3473
	public static final int GL_MAP1_NORMAL = 3474
	public static final int GL_MAP1_TEXTURE_COORD_1 = 3475
	public static final int GL_MAP1_TEXTURE_COORD_2 = 3476
	public static final int GL_MAP1_TEXTURE_COORD_3 = 3477
	public static final int GL_MAP1_TEXTURE_COORD_4 = 3478
	public static final int GL_MAP1_VERTEX_3 = 3479
	public static final int GL_MAP1_VERTEX_4 = 3480
	public static final int GL_MAP2_COLOR_4 = 3504
	public static final int GL_MAP2_INDEX = 3505
	public static final int GL_MAP2_NORMAL = 3506
	public static final int GL_MAP2_TEXTURE_COORD_1 = 3507
	public static final int GL_MAP2_TEXTURE_COORD_2 = 3508
	public static final int GL_MAP2_TEXTURE_COORD_3 = 3509
	public static final int GL_MAP2_TEXTURE_COORD_4 = 3510
	public static final int GL_MAP2_VERTEX_3 = 3511
	public static final int GL_MAP2_VERTEX_4 = 3512
	public static final int GL_MAP1_GRID_DOMAIN = 3536
	public static final int GL_MAP1_GRID_SEGMENTS = 3537
	public static final int GL_MAP2_GRID_DOMAIN = 3538
	public static final int GL_MAP2_GRID_SEGMENTS = 3539
	public static final int GL_TEXTURE_1D = 3552
	public static final int GL_TEXTURE_2D = 3553
	public static final int GL_FEEDBACK_BUFFER_POINTER = 3568
	public static final int GL_FEEDBACK_BUFFER_SIZE = 3569
	public static final int GL_FEEDBACK_BUFFER_TYPE = 3570
	public static final int GL_SELECTION_BUFFER_POINTER = 3571
	public static final int GL_SELECTION_BUFFER_SIZE = 3572
	public static final int GL_TEXTURE_WIDTH = 4096
	public static final int GL_TEXTURE_HEIGHT = 4097
	public static final int GL_TEXTURE_INTERNAL_FORMAT = 4099
	public static final int GL_TEXTURE_BORDER_COLOR = 4100
	public static final int GL_TEXTURE_BORDER = 4101
	public static final int GL_DONT_CARE = 4352
	public static final int GL_FASTEST = 4353
	public static final int GL_NICEST = 4354
	public static final int GL_LIGHT0 = 16384
	public static final int GL_LIGHT1 = 16385
	public static final int GL_LIGHT2 = 16386
	public static final int GL_LIGHT3 = 16387
	public static final int GL_LIGHT4 = 16388
	public static final int GL_LIGHT5 = 16389
	public static final int GL_LIGHT6 = 16390
	public static final int GL_LIGHT7 = 16391
	public static final int GL_AMBIENT = 4608
	public static final int GL_DIFFUSE = 4609
	public static final int GL_SPECULAR = 4610
	public static final int GL_POSITION = 4611
	public static final int GL_SPOT_DIRECTION = 4612
	public static final int GL_SPOT_EXPONENT = 4613
	public static final int GL_SPOT_CUTOFF = 4614
	public static final int GL_CONSTANT_ATTENUATION = 4615
	public static final int GL_LINEAR_ATTENUATION = 4616
	public static final int GL_QUADRATIC_ATTENUATION = 4617
	public static final int GL_COMPILE = 4864
	public static final int GL_COMPILE_AND_EXECUTE = 4865
	public static final int GL_CLEAR = 5376
	public static final int GL_AND = 5377
	public static final int GL_AND_REVERSE = 5378
	public static final int GL_COPY = 5379
	public static final int GL_AND_INVERTED = 5380
	public static final int GL_NOOP = 5381
	public static final int GL_XOR = 5382
	public static final int GL_OR = 5383
	public static final int GL_NOR = 5384
	public static final int GL_EQUIV = 5385
	public static final int GL_INVERT = 5386
	public static final int GL_OR_REVERSE = 5387
	public static final int GL_COPY_INVERTED = 5388
	public static final int GL_OR_INVERTED = 5389
	public static final int GL_NAND = 5390
	public static final int GL_SET = 5391
	public static final int GL_EMISSION = 5632
	public static final int GL_SHININESS = 5633
	public static final int GL_AMBIENT_AND_DIFFUSE = 5634
	public static final int GL_COLOR_INDEXES = 5635
	public static final int GL_MODELVIEW = 5888
	public static final int GL_PROJECTION = 5889
	public static final int GL_TEXTURE = 5890
	public static final int GL_COLOR = 6144
	public static final int GL_DEPTH = 6145
	public static final int GL_STENCIL = 6146
	public static final int GL_COLOR_INDEX = 6400
	public static final int GL_STENCIL_INDEX = 6401
	public static final int GL_DEPTH_COMPONENT = 6402
	public static final int GL_RED = 6403
	public static final int GL_GREEN = 6404
	public static final int GL_BLUE = 6405
	public static final int GL_ALPHA = 6406
	public static final int GL_RGB = 6407
	public static final int GL_RGBA = 6408
	public static final int GL_LUMINANCE = 6409
	public static final int GL_LUMINANCE_ALPHA = 6410
	public static final int GL_BITMAP = 6656
	public static final int GL_POINT = 6912
	public static final int GL_LINE = 6913
	public static final int GL_FILL = 6914
	public static final int GL_RENDER = 7168
	public static final int GL_FEEDBACK = 7169
	public static final int GL_SELECT = 7170
	public static final int GL_FLAT = 7424
	public static final int GL_SMOOTH = 7425
	public static final int GL_KEEP = 7680
	public static final int GL_REPLACE = 7681
	public static final int GL_INCR = 7682
	public static final int GL_DECR = 7683
	public static final int GL_VENDOR = 7936
	public static final int GL_RENDERER = 7937
	public static final int GL_VERSION = 7938
	public static final int GL_EXTENSIONS = 7939
	public static final int GL_S = 8192
	public static final int GL_T = 8193
	public static final int GL_R = 8194
	public static final int GL_Q = 8195
	public static final int GL_MODULATE = 8448
	public static final int GL_DECAL = 8449
	public static final int GL_TEXTURE_ENV_MODE = 8704
	public static final int GL_TEXTURE_ENV_COLOR = 8705
	public static final int GL_TEXTURE_ENV = 8960
	public static final int GL_EYE_LINEAR = 9216
	public static final int GL_OBJECT_LINEAR = 9217
	public static final int GL_SPHERE_MAP = 9218
	public static final int GL_TEXTURE_GEN_MODE = 9472
	public static final int GL_OBJECT_PLANE = 9473
	public static final int GL_EYE_PLANE = 9474
	public static final int GL_NEAREST = 9728
	public static final int GL_LINEAR = 9729
	public static final int GL_NEAREST_MIPMAP_NEAREST = 9984
	public static final int GL_LINEAR_MIPMAP_NEAREST = 9985
	public static final int GL_NEAREST_MIPMAP_LINEAR = 9986
	public static final int GL_LINEAR_MIPMAP_LINEAR = 9987
	public static final int GL_TEXTURE_MAG_FILTER = 10240
	public static final int GL_TEXTURE_MIN_FILTER = 10241
	public static final int GL_TEXTURE_WRAP_S = 10242
	public static final int GL_TEXTURE_WRAP_T = 10243
	public static final int GL_CLAMP = 10496
	public static final int GL_REPEAT = 10497
	public static final int GL_CLIENT_PIXEL_STORE_BIT = 1
	public static final int GL_CLIENT_VERTEX_ARRAY_BIT = 2
	public static final int GL_ALL_CLIENT_ATTRIB_BITS = -1
	public static final int GL_POLYGON_OFFSET_FACTOR = 32824
	public static final int GL_POLYGON_OFFSET_UNITS = 10752
	public static final int GL_POLYGON_OFFSET_POINT = 10753
	public static final int GL_POLYGON_OFFSET_LINE = 10754
	public static final int GL_POLYGON_OFFSET_FILL = 32823
	public static final int GL_ALPHA4 = 32827
	public static final int GL_ALPHA8 = 32828
	public static final int GL_ALPHA12 = 32829
	public static final int GL_ALPHA16 = 32830
	public static final int GL_LUMINANCE4 = 32831
	public static final int GL_LUMINANCE8 = 32832
	public static final int GL_LUMINANCE12 = 32833
	public static final int GL_LUMINANCE16 = 32834
	public static final int GL_LUMINANCE4_ALPHA4 = 32835
	public static final int GL_LUMINANCE6_ALPHA2 = 32836
	public static final int GL_LUMINANCE8_ALPHA8 = 32837
	public static final int GL_LUMINANCE12_ALPHA4 = 32838
	public static final int GL_LUMINANCE12_ALPHA12 = 32839
	public static final int GL_LUMINANCE16_ALPHA16 = 32840
	public static final int GL_INTENSITY = 32841
	public static final int GL_INTENSITY4 = 32842
	public static final int GL_INTENSITY8 = 32843
	public static final int GL_INTENSITY12 = 32844
	public static final int GL_INTENSITY16 = 32845
	public static final int GL_R3_G3_B2 = 10768
	public static final int GL_RGB4 = 32847
	public static final int GL_RGB5 = 32848
	public static final int GL_RGB8 = 32849
	public static final int GL_RGB10 = 32850
	public static final int GL_RGB12 = 32851
	public static final int GL_RGB16 = 32852
	public static final int GL_RGBA2 = 32853
	public static final int GL_RGBA4 = 32854
	public static final int GL_RGB5_A1 = 32855
	public static final int GL_RGBA8 = 32856
	public static final int GL_RGB10_A2 = 32857
	public static final int GL_RGBA12 = 32858
	public static final int GL_RGBA16 = 32859
	public static final int GL_TEXTURE_RED_SIZE = 32860
	public static final int GL_TEXTURE_GREEN_SIZE = 32861
	public static final int GL_TEXTURE_BLUE_SIZE = 32862
	public static final int GL_TEXTURE_ALPHA_SIZE = 32863
	public static final int GL_TEXTURE_LUMINANCE_SIZE = 32864
	public static final int GL_TEXTURE_INTENSITY_SIZE = 32865
	public static final int GL_PROXY_TEXTURE_1D = 32867
	public static final int GL_PROXY_TEXTURE_2D = 32868
	public static final int GL_TEXTURE_PRIORITY = 32870
	public static final int GL_TEXTURE_RESIDENT = 32871
	public static final int GL_TEXTURE_BINDING_1D = 32872
	public static final int GL_TEXTURE_BINDING_2D = 32873
	public static final int GL_VERTEX_ARRAY = 32884
	public static final int GL_NORMAL_ARRAY = 32885
	public static final int GL_COLOR_ARRAY = 32886
	public static final int GL_INDEX_ARRAY = 32887
	public static final int GL_TEXTURE_COORD_ARRAY = 32888
	public static final int GL_EDGE_FLAG_ARRAY = 32889
	public static final int GL_VERTEX_ARRAY_SIZE = 32890
	public static final int GL_VERTEX_ARRAY_TYPE = 32891
	public static final int GL_VERTEX_ARRAY_STRIDE = 32892
	public static final int GL_NORMAL_ARRAY_TYPE = 32894
	public static final int GL_NORMAL_ARRAY_STRIDE = 32895
	public static final int GL_COLOR_ARRAY_SIZE = 32897
	public static final int GL_COLOR_ARRAY_TYPE = 32898
	public static final int GL_COLOR_ARRAY_STRIDE = 32899
	public static final int GL_INDEX_ARRAY_TYPE = 32901
	public static final int GL_INDEX_ARRAY_STRIDE = 32902
	public static final int GL_TEXTURE_COORD_ARRAY_SIZE = 32904
	public static final int GL_TEXTURE_COORD_ARRAY_TYPE = 32905
	public static final int GL_TEXTURE_COORD_ARRAY_STRIDE = 32906
	public static final int GL_EDGE_FLAG_ARRAY_STRIDE = 32908
	public static final int GL_VERTEX_ARRAY_POINTER = 32910
	public static final int GL_NORMAL_ARRAY_POINTER = 32911
	public static final int GL_COLOR_ARRAY_POINTER = 32912
	public static final int GL_INDEX_ARRAY_POINTER = 32913
	public static final int GL_TEXTURE_COORD_ARRAY_POINTER = 32914
	public static final int GL_EDGE_FLAG_ARRAY_POINTER = 32915
	public static final int GL_V2F = 10784
	public static final int GL_V3F = 10785
	public static final int GL_C4UB_V2F = 10786
	public static final int GL_C4UB_V3F = 10787
	public static final int GL_C3F_V3F = 10788
	public static final int GL_N3F_V3F = 10789
	public static final int GL_C4F_N3F_V3F = 10790
	public static final int GL_T2F_V3F = 10791
	public static final int GL_T4F_V4F = 10792
	public static final int GL_T2F_C4UB_V3F = 10793
	public static final int GL_T2F_C3F_V3F = 10794
	public static final int GL_T2F_N3F_V3F = 10795
	public static final int GL_T2F_C4F_N3F_V3F = 10796
	public static final int GL_T4F_C4F_N3F_V4F = 10797
	public static final int GL_LOGIC_OP = 3057
	public static final int GL_TEXTURE_COMPONENTS = 4099

	public static void glNamedFramebufferDrawBuffers(int arg0, IntBuffer arg1) { GL45.glNamedFramebufferDrawBuffers(arg0, arg1) }

	public static void glGetNamedBufferSubData(int arg0, long arg1, ShortBuffer arg2) { GL45.glGetNamedBufferSubData(arg0, arg1, arg2) }

	public static void glGetNamedBufferSubData(int arg0, long arg1, IntBuffer arg2) { GL45.glGetNamedBufferSubData(arg0, arg1, arg2) }

	public static void glGetNamedBufferSubData(int arg0, long arg1, FloatBuffer arg2) { GL45.glGetNamedBufferSubData(arg0, arg1, arg2) }

	public static void glGetNamedBufferSubData(int arg0, long arg1, ByteBuffer arg2) { GL45.glGetNamedBufferSubData(arg0, arg1, arg2) }

	public static void glGetNamedBufferSubData(int arg0, long arg1, DoubleBuffer arg2) { GL45.glGetNamedBufferSubData(arg0, arg1, arg2) }

	public static ByteBuffer glGetNamedBufferPointer(int arg0, int arg1) { GL45.glGetNamedBufferPointer(arg0, arg1) }

	public static long glGetNamedBufferParameteri64(int arg0, int arg1) { GL45.glGetNamedBufferParameteri64(arg0, arg1) }

	public static void glNamedFramebufferDrawBuffer(int arg0, int arg1) { GL45.glNamedFramebufferDrawBuffer(arg0, arg1) }

	public static void glNamedFramebufferRenderbuffer(int arg0, int arg1, int arg2, int arg3) { GL45.glNamedFramebufferRenderbuffer(arg0, arg1, arg2, arg3) }

	public static void glNamedBufferData(int arg0, IntBuffer arg1, int arg2) { GL45.glNamedBufferData(arg0, arg1, arg2) }

	public static void glNamedBufferData(int arg0, FloatBuffer arg1, int arg2) { GL45.glNamedBufferData(arg0, arg1, arg2) }

	public static void glNamedBufferData(int arg0, ByteBuffer arg1, int arg2) { GL45.glNamedBufferData(arg0, arg1, arg2) }

	public static void glNamedBufferData(int arg0, DoubleBuffer arg1, int arg2) { GL45.glNamedBufferData(arg0, arg1, arg2) }

	public static void glNamedBufferData(int arg0, long arg1, int arg2) { GL45.glNamedBufferData(arg0, arg1, arg2) }

	public static void glNamedBufferData(int arg0, ShortBuffer arg1, int arg2) { GL45.glNamedBufferData(arg0, arg1, arg2) }

	public static void glNamedFramebufferTextureLayer(int arg0, int arg1, int arg2, int arg3, int arg4) { GL45.glNamedFramebufferTextureLayer(arg0, arg1, arg2, arg3, arg4) }

	public static void glFlushMappedNamedBufferRange(int arg0, long arg1, long arg2) { GL45.glFlushMappedNamedBufferRange(arg0, arg1, arg2) }

	public static void glNamedBufferSubData(int arg0, long arg1, FloatBuffer arg2) { GL45.glNamedBufferSubData(arg0, arg1, arg2) }

	public static void glNamedBufferSubData(int arg0, long arg1, DoubleBuffer arg2) { GL45.glNamedBufferSubData(arg0, arg1, arg2) }

	public static void glNamedBufferSubData(int arg0, long arg1, ByteBuffer arg2) { GL45.glNamedBufferSubData(arg0, arg1, arg2) }

	public static void glNamedBufferSubData(int arg0, long arg1, IntBuffer arg2) { GL45.glNamedBufferSubData(arg0, arg1, arg2) }

	public static void glNamedBufferSubData(int arg0, long arg1, ShortBuffer arg2) { GL45.glNamedBufferSubData(arg0, arg1, arg2) }

	public static void glNamedFramebufferParameteri(int arg0, int arg1, int arg2) { GL45.glNamedFramebufferParameteri(arg0, arg1, arg2) }

	public static void glNamedFramebufferReadBuffer(int arg0, int arg1) { GL45.glNamedFramebufferReadBuffer(arg0, arg1) }

	public static void glInvalidateNamedFramebufferData(int arg0, IntBuffer arg1) { GL45.glInvalidateNamedFramebufferData(arg0, arg1) }

	public static int glGetNamedBufferParameteri(int arg0, int arg1) { GL45.glGetNamedBufferParameteri(arg0, arg1) }

	public static void glClearNamedFramebuffer(int arg0, int arg1, int arg2, IntBuffer arg3) { GL45.glClearNamedFramebuffer(arg0, arg1, arg2, arg3) }

	public static void glClearNamedFramebuffer(int arg0, int arg1, int arg2, FloatBuffer arg3) { GL45.glClearNamedFramebuffer(arg0, arg1, arg2, arg3) }

	public static void glClearNamedFramebufferu(int arg0, int arg1, int arg2, IntBuffer arg3) { GL45.glClearNamedFramebufferu(arg0, arg1, arg2, arg3) }

	public static void glClearNamedBufferData(int arg0, int arg1, int arg2, int arg3, ByteBuffer arg4) { GL45.glClearNamedBufferData(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetNamedBufferParameter(int arg0, int arg1, LongBuffer arg2) { GL45.glGetNamedBufferParameter(arg0, arg1, arg2) }

	public static void glGetNamedBufferParameter(int arg0, int arg1, IntBuffer arg2) { GL45.glGetNamedBufferParameter(arg0, arg1, arg2) }

	public static void glClearNamedBufferSubData(int arg0, int arg1, long arg2, long arg3, int arg4, int arg5, ByteBuffer arg6) { GL45.glClearNamedBufferSubData(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static ByteBuffer glMapNamedBufferRange(int arg0, long arg1, long arg2, int arg3, ByteBuffer arg4) { GL45.glMapNamedBufferRange(arg0, arg1, arg2, arg3, arg4) }

	public static void glCopyNamedBufferSubData(int arg0, int arg1, long arg2, long arg3, long arg4) { GL45.glCopyNamedBufferSubData(arg0, arg1, arg2, arg3, arg4) }

	public static boolean glUnmapNamedBuffer(int arg0) { GL45.glUnmapNamedBuffer(arg0) }

	public static int glCreateFramebuffers() { GL45.glCreateFramebuffers() }

	public static void glCreateFramebuffers(IntBuffer arg0) { GL45.glCreateFramebuffers(arg0) }

	public static void glNamedFramebufferTexture(int arg0, int arg1, int arg2, int arg3) { GL45.glNamedFramebufferTexture(arg0, arg1, arg2, arg3) }

	public static void glCreateTransformFeedbacks(IntBuffer arg0) { GL45.glCreateTransformFeedbacks(arg0) }

	public static int glCreateTransformFeedbacks() { GL45.glCreateTransformFeedbacks() }

	public static void glTransformFeedbackBufferRange(int arg0, int arg1, int arg2, long arg3, long arg4) { GL45.glTransformFeedbackBufferRange(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTransformFeedback(int arg0, int arg1, IntBuffer arg2) { GL45.glGetTransformFeedback(arg0, arg1, arg2) }

	public static void glGetTransformFeedback(int arg0, int arg1, int arg2, IntBuffer arg3) { GL45.glGetTransformFeedback(arg0, arg1, arg2, arg3) }

	public static void glGetTransformFeedback(int arg0, int arg1, int arg2, LongBuffer arg3) { GL45.glGetTransformFeedback(arg0, arg1, arg2, arg3) }

	public static long glGetTransformFeedbacki64(int arg0, int arg1, int arg2) { GL45.glGetTransformFeedbacki64(arg0, arg1, arg2) }

	public static int glGetTransformFeedbacki(int arg0, int arg1, int arg2) { GL45.glGetTransformFeedbacki(arg0, arg1, arg2) }

	public static int glGetTransformFeedbacki(int arg0, int arg1) { GL45.glGetTransformFeedbacki(arg0, arg1) }

	public static void glTransformFeedbackBufferBase(int arg0, int arg1, int arg2) { GL45.glTransformFeedbackBufferBase(arg0, arg1, arg2) }

	public static void glNamedBufferStorage(int arg0, ShortBuffer arg1, int arg2) { GL45.glNamedBufferStorage(arg0, arg1, arg2) }

	public static void glNamedBufferStorage(int arg0, ByteBuffer arg1, int arg2) { GL45.glNamedBufferStorage(arg0, arg1, arg2) }

	public static void glNamedBufferStorage(int arg0, FloatBuffer arg1, int arg2) { GL45.glNamedBufferStorage(arg0, arg1, arg2) }

	public static void glNamedBufferStorage(int arg0, DoubleBuffer arg1, int arg2) { GL45.glNamedBufferStorage(arg0, arg1, arg2) }

	public static void glNamedBufferStorage(int arg0, LongBuffer arg1, int arg2) { GL45.glNamedBufferStorage(arg0, arg1, arg2) }

	public static void glNamedBufferStorage(int arg0, IntBuffer arg1, int arg2) { GL45.glNamedBufferStorage(arg0, arg1, arg2) }

	public static void glNamedBufferStorage(int arg0, long arg1, int arg2) { GL45.glNamedBufferStorage(arg0, arg1, arg2) }

	public static void glCreateBuffers(IntBuffer arg0) { GL45.glCreateBuffers(arg0) }

	public static int glCreateBuffers() { GL45.glCreateBuffers() }

	public static void glClipControl(int arg0, int arg1) { GL45.glClipControl(arg0, arg1) }

	public static ByteBuffer glMapNamedBuffer(int arg0, int arg1, ByteBuffer arg2) { GL45.glMapNamedBuffer(arg0, arg1, arg2) }

	public static ByteBuffer glMapNamedBuffer(int arg0, int arg1, long arg2, ByteBuffer arg3) { GL45.glMapNamedBuffer(arg0, arg1, arg2, arg3) }

	public static int glCreateTextures(int arg0) { GL45.glCreateTextures(arg0) }

	public static void glCreateTextures(int arg0, IntBuffer arg1) { GL45.glCreateTextures(arg0, arg1) }

	public static void glTextureBuffer(int arg0, int arg1, int arg2) { GL45.glTextureBuffer(arg0, arg1, arg2) }

	public static int glCreateSamplers() { GL45.glCreateSamplers() }

	public static void glCreateSamplers(IntBuffer arg0) { GL45.glCreateSamplers(arg0) }

	public static void glGetnUniformu(int arg0, int arg1, IntBuffer arg2) { GL45.glGetnUniformu(arg0, arg1, arg2) }

	public static void glGetnUniform(int arg0, int arg1, IntBuffer arg2) { GL45.glGetnUniform(arg0, arg1, arg2) }

	public static void glGetnUniform(int arg0, int arg1, FloatBuffer arg2) { GL45.glGetnUniform(arg0, arg1, arg2) }

	public static int glCreateQueries(int arg0) { GL45.glCreateQueries(arg0) }

	public static void glCreateQueries(int arg0, IntBuffer arg1) { GL45.glCreateQueries(arg0, arg1) }

	public static void glTextureBarrier() { GL45.glTextureBarrier() }

	public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, long arg7) { GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ByteBuffer arg6) { GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, DoubleBuffer arg6) { GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, IntBuffer arg6) { GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ShortBuffer arg6) { GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, FloatBuffer arg6) { GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glGetVertexArray(int arg0, int arg1, IntBuffer arg2) { GL45.glGetVertexArray(arg0, arg1, arg2) }

	public static int glGetVertexArray(int arg0, int arg1) { GL45.glGetVertexArray(arg0, arg1) }

	public static void glGetNamedFramebufferAttachmentParameter(int arg0, int arg1, int arg2, IntBuffer arg3) { GL45.glGetNamedFramebufferAttachmentParameter(arg0, arg1, arg2, arg3) }

	public static int glGetNamedFramebufferAttachmentParameter(int arg0, int arg1, int arg2) { GL45.glGetNamedFramebufferAttachmentParameter(arg0, arg1, arg2) }

	public static void glInvalidateNamedFramebufferSubData(int arg0, IntBuffer arg1, int arg2, int arg3, int arg4, int arg5) { GL45.glInvalidateNamedFramebufferSubData(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glNamedRenderbufferStorageMultisample(int arg0, int arg1, int arg2, int arg3, int arg4) { GL45.glNamedRenderbufferStorageMultisample(arg0, arg1, arg2, arg3, arg4) }

	public static int glGetGraphicsResetStatus() { GL45.glGetGraphicsResetStatus() }

	public static int glCreateProgramPipelines() { GL45.glCreateProgramPipelines() }

	public static void glCreateProgramPipelines(IntBuffer arg0) { GL45.glCreateProgramPipelines(arg0) }

	public static void glVertexArrayAttribBinding(int arg0, int arg1, int arg2) { GL45.glVertexArrayAttribBinding(arg0, arg1, arg2) }

	public static void glGetVertexArrayIndexed(int arg0, int arg1, int arg2, IntBuffer arg3) { GL45.glGetVertexArrayIndexed(arg0, arg1, arg2, arg3) }

	public static int glGetVertexArrayIndexed(int arg0, int arg1, int arg2) { GL45.glGetVertexArrayIndexed(arg0, arg1, arg2) }

	public static void glMemoryBarrierByRegion(int arg0) { GL45.glMemoryBarrierByRegion(arg0) }

	public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, IntBuffer arg8) { GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, FloatBuffer arg8) { GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, ShortBuffer arg8) { GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, long arg9) { GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, DoubleBuffer arg8) { GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, ByteBuffer arg8) { GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, FloatBuffer arg10) { GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, DoubleBuffer arg10) { GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, ByteBuffer arg10) { GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, long arg11) { GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11) }

	public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, ShortBuffer arg10) { GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, IntBuffer arg10) { GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glVertexArrayAttribLFormat(int arg0, int arg1, int arg2, int arg3, int arg4) { GL45.glVertexArrayAttribLFormat(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexArrayAttribIFormat(int arg0, int arg1, int arg2, int arg3, int arg4) { GL45.glVertexArrayAttribIFormat(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexArrayBindingDivisor(int arg0, int arg1, int arg2) { GL45.glVertexArrayBindingDivisor(arg0, arg1, arg2) }

	public static long glGetVertexArrayIndexed64i(int arg0, int arg1, int arg2) { GL45.glGetVertexArrayIndexed64i(arg0, arg1, arg2) }

	public static void glGetVertexArrayIndexed64i(int arg0, int arg1, int arg2, LongBuffer arg3) { GL45.glGetVertexArrayIndexed64i(arg0, arg1, arg2, arg3) }

	public static void glCopyTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) { GL45.glCopyTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glBlitNamedFramebuffer(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) { GL45.glBlitNamedFramebuffer(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11) }

	public static void glCompressedTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) { GL45.glCompressedTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glCompressedTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, ByteBuffer arg5) { GL45.glCompressedTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glGetNamedRenderbufferParameter(int arg0, int arg1, IntBuffer arg2) { GL45.glGetNamedRenderbufferParameter(arg0, arg1, arg2) }

	public static int glGetNamedRenderbufferParameter(int arg0, int arg1) { GL45.glGetNamedRenderbufferParameter(arg0, arg1) }

	public static void glTextureStorage3DMultisample(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6) { GL45.glTextureStorage3DMultisample(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTextureStorage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) { GL45.glTextureStorage3D(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glTextureParameterf(int arg0, int arg1, float arg2) { GL45.glTextureParameterf(arg0, arg1, arg2) }

	public static void glTextureStorage1D(int arg0, int arg1, int arg2, int arg3) { GL45.glTextureStorage1D(arg0, arg1, arg2, arg3) }

	public static void glCompressedTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, ByteBuffer arg7) { GL45.glCompressedTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glCompressedTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) { GL45.glCompressedTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTextureParameter(int arg0, int arg1, FloatBuffer arg2) { GL45.glTextureParameter(arg0, arg1, arg2) }

	public static void glTextureParameter(int arg0, int arg1, IntBuffer arg2) { GL45.glTextureParameter(arg0, arg1, arg2) }

	public static void glTextureStorage2D(int arg0, int arg1, int arg2, int arg3, int arg4) { GL45.glTextureStorage2D(arg0, arg1, arg2, arg3, arg4) }

	public static void glCopyTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) { GL45.glCopyTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glGetNamedFramebufferParameter(int arg0, int arg1, IntBuffer arg2) { GL45.glGetNamedFramebufferParameter(arg0, arg1, arg2) }

	public static int glGetNamedFramebufferParameter(int arg0, int arg1) { GL45.glGetNamedFramebufferParameter(arg0, arg1) }

	public static void glTextureStorage2DMultisample(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) { GL45.glTextureStorage2DMultisample(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glTextureParameteri(int arg0, int arg1, int arg2) { GL45.glTextureParameteri(arg0, arg1, arg2) }

	public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, long arg10) { GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, FloatBuffer arg10) { GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, ShortBuffer arg10) { GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, DoubleBuffer arg10) { GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, IntBuffer arg10) { GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, ByteBuffer arg10) { GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTextureBufferRange(int arg0, int arg1, int arg2, long arg3, long arg4) { GL45.glTextureBufferRange(arg0, arg1, arg2, arg3, arg4) }

	public static int glCheckNamedFramebufferStatus(int arg0, int arg1) { GL45.glCheckNamedFramebufferStatus(arg0, arg1) }

	public static void glTextureParameterI(int arg0, int arg1, IntBuffer arg2) { GL45.glTextureParameterI(arg0, arg1, arg2) }

	public static void glClearNamedFramebufferfi(int arg0, int arg1, float arg2, int arg3) { GL45.glClearNamedFramebufferfi(arg0, arg1, arg2, arg3) }

	public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, ShortBuffer arg8) { GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, IntBuffer arg8) { GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, FloatBuffer arg8) { GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, DoubleBuffer arg8) { GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, ByteBuffer arg8) { GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) { GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) { GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, FloatBuffer arg6) { GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, DoubleBuffer arg6) { GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ByteBuffer arg6) { GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ShortBuffer arg6) { GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, IntBuffer arg6) { GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glCopyTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) { GL45.glCopyTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glTextureParameterIu(int arg0, int arg1, IntBuffer arg2) { GL45.glTextureParameterIu(arg0, arg1, arg2) }

	public static int glCreateRenderbuffers() { GL45.glCreateRenderbuffers() }

	public static void glCreateRenderbuffers(IntBuffer arg0) { GL45.glCreateRenderbuffers(arg0) }

	public static void glNamedRenderbufferStorage(int arg0, int arg1, int arg2, int arg3) { GL45.glNamedRenderbufferStorage(arg0, arg1, arg2, arg3) }

	public static void glCompressedTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, ByteBuffer arg10) { GL45.glCompressedTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glCompressedTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, long arg10) { GL45.glCompressedTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static float glGetTextureLevelParameterf(int arg0, int arg1, int arg2) { GL45.glGetTextureLevelParameterf(arg0, arg1, arg2) }

	public static void glGetTextureLevelParameter(int arg0, int arg1, int arg2, IntBuffer arg3) { GL45.glGetTextureLevelParameter(arg0, arg1, arg2, arg3) }

	public static void glGetTextureLevelParameter(int arg0, int arg1, int arg2, FloatBuffer arg3) { GL45.glGetTextureLevelParameter(arg0, arg1, arg2, arg3) }

	public static int glGetTextureParameteri(int arg0, int arg1) { GL45.glGetTextureParameteri(arg0, arg1) }

	public static void glCreateVertexArrays(IntBuffer arg0) { GL45.glCreateVertexArrays(arg0) }

	public static int glCreateVertexArrays() { GL45.glCreateVertexArrays() }

	public static void glGetTextureParameterIu(int arg0, int arg1, IntBuffer arg2) { GL45.glGetTextureParameterIu(arg0, arg1, arg2) }

	public static void glEnableVertexArrayAttrib(int arg0, int arg1) { GL45.glEnableVertexArrayAttrib(arg0, arg1) }

	public static int glGetTextureParameterIui(int arg0, int arg1) { GL45.glGetTextureParameterIui(arg0, arg1) }

	public static void glDisableVertexArrayAttrib(int arg0, int arg1) { GL45.glDisableVertexArrayAttrib(arg0, arg1) }

	public static void glBindTextureUnit(int arg0, int arg1) { GL45.glBindTextureUnit(arg0, arg1) }

	public static float glGetTextureParameterf(int arg0, int arg1) { GL45.glGetTextureParameterf(arg0, arg1) }

	public static void glVertexArrayVertexBuffer(int arg0, int arg1, int arg2, long arg3, int arg4) { GL45.glVertexArrayVertexBuffer(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTextureParameter(int arg0, int arg1, IntBuffer arg2) { GL45.glGetTextureParameter(arg0, arg1, arg2) }

	public static void glGetTextureParameter(int arg0, int arg1, FloatBuffer arg2) { GL45.glGetTextureParameter(arg0, arg1, arg2) }

	public static void glVertexArrayElementBuffer(int arg0, int arg1) { GL45.glVertexArrayElementBuffer(arg0, arg1) }

	public static void glVertexArrayVertexBuffers(int arg0, int arg1, int arg2, IntBuffer arg3, PointerBuffer arg4, IntBuffer arg5) { GL45.glVertexArrayVertexBuffers(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glGetTextureParameterI(int arg0, int arg1, IntBuffer arg2) { GL45.glGetTextureParameterI(arg0, arg1, arg2) }

	public static void glGenerateTextureMipmap(int arg0) { GL45.glGenerateTextureMipmap(arg0) }

	public static void glVertexArrayAttribFormat(int arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) { GL45.glVertexArrayAttribFormat(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, ByteBuffer arg4) { GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, ShortBuffer arg4) { GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, IntBuffer arg4) { GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, FloatBuffer arg4) { GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, DoubleBuffer arg4) { GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, int arg4, long arg5) { GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static int glGetTextureLevelParameteri(int arg0, int arg1, int arg2) { GL45.glGetTextureLevelParameteri(arg0, arg1, arg2) }

	public static int glGetTextureParameterIi(int arg0, int arg1) { GL45.glGetTextureParameterIi(arg0, arg1) }

	public static void glGetCompressedTextureImage(int arg0, int arg1, IntBuffer arg2) { GL45.glGetCompressedTextureImage(arg0, arg1, arg2) }

	public static void glGetCompressedTextureImage(int arg0, int arg1, ByteBuffer arg2) { GL45.glGetCompressedTextureImage(arg0, arg1, arg2) }

	public static void glGetCompressedTextureImage(int arg0, int arg1, ShortBuffer arg2) { GL45.glGetCompressedTextureImage(arg0, arg1, arg2) }

	public static void glGetCompressedTextureImage(int arg0, int arg1, int arg2, long arg3) { GL45.glGetCompressedTextureImage(arg0, arg1, arg2, arg3) }

	public static void glBindSamplers(int arg0, int arg1, IntBuffer arg2) { GL44.glBindSamplers(arg0, arg1, arg2) }

	public static void glBufferStorage(int arg0, long arg1, int arg2) { GL44.glBufferStorage(arg0, arg1, arg2) }

	public static void glBufferStorage(int arg0, DoubleBuffer arg1, int arg2) { GL44.glBufferStorage(arg0, arg1, arg2) }

	public static void glBufferStorage(int arg0, ByteBuffer arg1, int arg2) { GL44.glBufferStorage(arg0, arg1, arg2) }

	public static void glBufferStorage(int arg0, IntBuffer arg1, int arg2) { GL44.glBufferStorage(arg0, arg1, arg2) }

	public static void glBufferStorage(int arg0, ShortBuffer arg1, int arg2) { GL44.glBufferStorage(arg0, arg1, arg2) }

	public static void glBufferStorage(int arg0, LongBuffer arg1, int arg2) { GL44.glBufferStorage(arg0, arg1, arg2) }

	public static void glBufferStorage(int arg0, FloatBuffer arg1, int arg2) { GL44.glBufferStorage(arg0, arg1, arg2) }

	public static void glBindTextures(int arg0, int arg1, IntBuffer arg2) { GL44.glBindTextures(arg0, arg1, arg2) }

	public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, LongBuffer arg4) { GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, ByteBuffer arg4) { GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, DoubleBuffer arg4) { GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, FloatBuffer arg4) { GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, ShortBuffer arg4) { GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, IntBuffer arg4) { GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glBindBuffersRange(int arg0, int arg1, int arg2, IntBuffer arg3, PointerBuffer arg4, PointerBuffer arg5) { GL44.glBindBuffersRange(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glBindImageTextures(int arg0, int arg1, IntBuffer arg2) { GL44.glBindImageTextures(arg0, arg1, arg2) }

	public static void glBindBuffersBase(int arg0, int arg1, int arg2, IntBuffer arg3) { GL44.glBindBuffersBase(arg0, arg1, arg2, arg3) }

	public static void glBindVertexBuffers(int arg0, int arg1, IntBuffer arg2, PointerBuffer arg3, IntBuffer arg4) { GL44.glBindVertexBuffers(arg0, arg1, arg2, arg3, arg4) }

	public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, ByteBuffer arg10) { GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, DoubleBuffer arg10) { GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, LongBuffer arg10) { GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, ShortBuffer arg10) { GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, IntBuffer arg10) { GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, FloatBuffer arg10) { GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glObjectPtrLabel(PointerWrapper arg0, ByteBuffer arg1) { GL43.glObjectPtrLabel(arg0, arg1) }

	public static void glObjectPtrLabel(PointerWrapper arg0, CharSequence arg1) { GL43.glObjectPtrLabel(arg0, arg1) }

	public static void glPushDebugGroup(int arg0, int arg1, CharSequence arg2) { GL43.glPushDebugGroup(arg0, arg1, arg2) }

	public static void glPushDebugGroup(int arg0, int arg1, ByteBuffer arg2) { GL43.glPushDebugGroup(arg0, arg1, arg2) }

	public static void glObjectLabel(int arg0, int arg1, CharSequence arg2) { GL43.glObjectLabel(arg0, arg1, arg2) }

	public static void glObjectLabel(int arg0, int arg1, ByteBuffer arg2) { GL43.glObjectLabel(arg0, arg1, arg2) }

	public static void glTexBufferRange(int arg0, int arg1, int arg2, long arg3, long arg4) { GL43.glTexBufferRange(arg0, arg1, arg2, arg3, arg4) }

	public static void glTextureView(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) { GL43.glTextureView(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static String glGetObjectLabel(int arg0, int arg1, int arg2) { GL43.glGetObjectLabel(arg0, arg1, arg2) }

	public static void glGetObjectLabel(int arg0, int arg1, IntBuffer arg2, ByteBuffer arg3) { GL43.glGetObjectLabel(arg0, arg1, arg2, arg3) }

	public static void glPopDebugGroup() { GL43.glPopDebugGroup() }

	public static void glDispatchCompute(int arg0, int arg1, int arg2) { GL43.glDispatchCompute(arg0, arg1, arg2) }

	public static void glClearBufferData(int arg0, int arg1, int arg2, int arg3, ByteBuffer arg4) { GL43.glClearBufferData(arg0, arg1, arg2, arg3, arg4) }

	public static void glClearBufferSubData(int arg0, int arg1, long arg2, long arg3, int arg4, int arg5, ByteBuffer arg6) { GL43.glClearBufferSubData(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glInvalidateFramebuffer(int arg0, IntBuffer arg1) { GL43.glInvalidateFramebuffer(arg0, arg1) }

	public static void glMultiDrawElementsIndirect(int arg0, int arg1, IntBuffer arg2, int arg3, int arg4) { GL43.glMultiDrawElementsIndirect(arg0, arg1, arg2, arg3, arg4) }

	public static void glMultiDrawElementsIndirect(int arg0, int arg1, ByteBuffer arg2, int arg3, int arg4) { GL43.glMultiDrawElementsIndirect(arg0, arg1, arg2, arg3, arg4) }

	public static void glMultiDrawElementsIndirect(int arg0, int arg1, long arg2, int arg3, int arg4) { GL43.glMultiDrawElementsIndirect(arg0, arg1, arg2, arg3, arg4) }

	public static void glInvalidateTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) { GL43.glInvalidateTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static int glGetDebugMessageLog(int arg0, IntBuffer arg1, IntBuffer arg2, IntBuffer arg3, IntBuffer arg4, IntBuffer arg5, ByteBuffer arg6) { GL43.glGetDebugMessageLog(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glMultiDrawArraysIndirect(int arg0, IntBuffer arg1, int arg2, int arg3) { GL43.glMultiDrawArraysIndirect(arg0, arg1, arg2, arg3) }

	public static void glMultiDrawArraysIndirect(int arg0, long arg1, int arg2, int arg3) { GL43.glMultiDrawArraysIndirect(arg0, arg1, arg2, arg3) }

	public static void glMultiDrawArraysIndirect(int arg0, ByteBuffer arg1, int arg2, int arg3) { GL43.glMultiDrawArraysIndirect(arg0, arg1, arg2, arg3) }

	public static void glGetFramebufferParameter(int arg0, int arg1, IntBuffer arg2) { GL43.glGetFramebufferParameter(arg0, arg1, arg2) }

	public static void glInvalidateSubFramebuffer(int arg0, IntBuffer arg1, int arg2, int arg3, int arg4, int arg5) { GL43.glInvalidateSubFramebuffer(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glGetObjectPtrLabel(PointerWrapper arg0, IntBuffer arg1, ByteBuffer arg2) { GL43.glGetObjectPtrLabel(arg0, arg1, arg2) }

	public static String glGetObjectPtrLabel(PointerWrapper arg0, int arg1) { GL43.glGetObjectPtrLabel(arg0, arg1) }

	public static void glInvalidateBufferData(int arg0) { GL43.glInvalidateBufferData(arg0) }

	public static void glGetProgramInterface(int arg0, int arg1, int arg2, IntBuffer arg3) { GL43.glGetProgramInterface(arg0, arg1, arg2, arg3) }

	public static void glInvalidateBufferSubData(int arg0, long arg1, long arg2) { GL43.glInvalidateBufferSubData(arg0, arg1, arg2) }

	public static void glDebugMessageControl(int arg0, int arg1, int arg2, IntBuffer arg3, boolean arg4) { GL43.glDebugMessageControl(arg0, arg1, arg2, arg3, arg4) }

	public static void glDebugMessageCallback(KHRDebugCallback arg0) { GL43.glDebugMessageCallback(arg0) }

	public static void glFramebufferParameteri(int arg0, int arg1, int arg2) { GL43.glFramebufferParameteri(arg0, arg1, arg2) }

	public static void glDispatchComputeIndirect(long arg0) { GL43.glDispatchComputeIndirect(arg0) }

	public static int glGetProgramResourceIndex(int arg0, int arg1, CharSequence arg2) { GL43.glGetProgramResourceIndex(arg0, arg1, arg2) }

	public static int glGetProgramResourceIndex(int arg0, int arg1, ByteBuffer arg2) { GL43.glGetProgramResourceIndex(arg0, arg1, arg2) }

	public static long glGetInternalformati64(int arg0, int arg1, int arg2) { GL43.glGetInternalformati64(arg0, arg1, arg2) }

	public static void glGetInternalformat(int arg0, int arg1, int arg2, LongBuffer arg3) { GL43.glGetInternalformat(arg0, arg1, arg2, arg3) }

	public static void glCopyImageSubData(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14) { GL43.glCopyImageSubData(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14) }

	public static void glDebugMessageInsert(int arg0, int arg1, int arg2, int arg3, ByteBuffer arg4) { GL43.glDebugMessageInsert(arg0, arg1, arg2, arg3, arg4) }

	public static void glDebugMessageInsert(int arg0, int arg1, int arg2, int arg3, CharSequence arg4) { GL43.glDebugMessageInsert(arg0, arg1, arg2, arg3, arg4) }

	public static int glGetProgramInterfacei(int arg0, int arg1, int arg2) { GL43.glGetProgramInterfacei(arg0, arg1, arg2) }

	public static int glGetFramebufferParameteri(int arg0, int arg1) { GL43.glGetFramebufferParameteri(arg0, arg1) }

	public static void glInvalidateTexImage(int arg0, int arg1) { GL43.glInvalidateTexImage(arg0, arg1) }

	public static void glVertexBindingDivisor(int arg0, int arg1) { GL43.glVertexBindingDivisor(arg0, arg1) }

	public static void glVertexAttribFormat(int arg0, int arg1, int arg2, boolean arg3, int arg4) { GL43.glVertexAttribFormat(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexAttribBinding(int arg0, int arg1) { GL43.glVertexAttribBinding(arg0, arg1) }

	public static void glTexStorage3DMultisample(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6) { GL43.glTexStorage3DMultisample(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTexStorage2DMultisample(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) { GL43.glTexStorage2DMultisample(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static int glGetProgramResourceLocation(int arg0, int arg1, ByteBuffer arg2) { GL43.glGetProgramResourceLocation(arg0, arg1, arg2) }

	public static int glGetProgramResourceLocation(int arg0, int arg1, CharSequence arg2) { GL43.glGetProgramResourceLocation(arg0, arg1, arg2) }

	public static void glVertexAttribLFormat(int arg0, int arg1, int arg2, int arg3) { GL43.glVertexAttribLFormat(arg0, arg1, arg2, arg3) }

	public static void glGetProgramResourceName(int arg0, int arg1, int arg2, IntBuffer arg3, ByteBuffer arg4) { GL43.glGetProgramResourceName(arg0, arg1, arg2, arg3, arg4) }

	public static String glGetProgramResourceName(int arg0, int arg1, int arg2, int arg3) { GL43.glGetProgramResourceName(arg0, arg1, arg2, arg3) }

	public static void glShaderStorageBlockBinding(int arg0, int arg1, int arg2) { GL43.glShaderStorageBlockBinding(arg0, arg1, arg2) }

	public static void glVertexAttribIFormat(int arg0, int arg1, int arg2, int arg3) { GL43.glVertexAttribIFormat(arg0, arg1, arg2, arg3) }

	public static void glGetProgramResource(int arg0, int arg1, int arg2, IntBuffer arg3, IntBuffer arg4, IntBuffer arg5) { GL43.glGetProgramResource(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glBindVertexBuffer(int arg0, int arg1, long arg2, int arg3) { GL43.glBindVertexBuffer(arg0, arg1, arg2, arg3) }

	public static int glGetProgramResourceLocationIndex(int arg0, int arg1, ByteBuffer arg2) { GL43.glGetProgramResourceLocationIndex(arg0, arg1, arg2) }

	public static int glGetProgramResourceLocationIndex(int arg0, int arg1, CharSequence arg2) { GL43.glGetProgramResourceLocationIndex(arg0, arg1, arg2) }

	public static void glTexStorage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) { GL42.glTexStorage3D(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glTexStorage1D(int arg0, int arg1, int arg2, int arg3) { GL42.glTexStorage1D(arg0, arg1, arg2, arg3) }

	public static void glTexStorage2D(int arg0, int arg1, int arg2, int arg3, int arg4) { GL42.glTexStorage2D(arg0, arg1, arg2, arg3, arg4) }

	public static void glMemoryBarrier(int arg0) { GL42.glMemoryBarrier(arg0) }

	public static int glGetInternalformat(int arg0, int arg1, int arg2) { GL42.glGetInternalformat(arg0, arg1, arg2) }

	public static void glGetInternalformat(int arg0, int arg1, int arg2, IntBuffer arg3) { GL42.glGetInternalformat(arg0, arg1, arg2, arg3) }

	public static void glGetActiveAtomicCounterBuffer(int arg0, int arg1, int arg2, IntBuffer arg3) { GL42.glGetActiveAtomicCounterBuffer(arg0, arg1, arg2, arg3) }

	public static int glGetActiveAtomicCounterBuffer(int arg0, int arg1, int arg2) { GL42.glGetActiveAtomicCounterBuffer(arg0, arg1, arg2) }

	public static void glDrawTransformFeedbackInstanced(int arg0, int arg1, int arg2) { GL42.glDrawTransformFeedbackInstanced(arg0, arg1, arg2) }

	public static void glBindImageTexture(int arg0, int arg1, int arg2, boolean arg3, int arg4, int arg5, int arg6) { GL42.glBindImageTexture(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glDrawElementsInstancedBaseInstance(int arg0, ShortBuffer arg1, int arg2, int arg3) { GL42.glDrawElementsInstancedBaseInstance(arg0, arg1, arg2, arg3) }

	public static void glDrawElementsInstancedBaseInstance(int arg0, int arg1, int arg2, long arg3, int arg4, int arg5) { GL42.glDrawElementsInstancedBaseInstance(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glDrawElementsInstancedBaseInstance(int arg0, ByteBuffer arg1, int arg2, int arg3) { GL42.glDrawElementsInstancedBaseInstance(arg0, arg1, arg2, arg3) }

	public static void glDrawElementsInstancedBaseInstance(int arg0, IntBuffer arg1, int arg2, int arg3) { GL42.glDrawElementsInstancedBaseInstance(arg0, arg1, arg2, arg3) }

	public static void glDrawTransformFeedbackStreamInstanced(int arg0, int arg1, int arg2, int arg3) { GL42.glDrawTransformFeedbackStreamInstanced(arg0, arg1, arg2, arg3) }

	public static void glDrawElementsInstancedBaseVertexBaseInstance(int arg0, int arg1, int arg2, long arg3, int arg4, int arg5, int arg6) { GL42.glDrawElementsInstancedBaseVertexBaseInstance(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glDrawElementsInstancedBaseVertexBaseInstance(int arg0, ByteBuffer arg1, int arg2, int arg3, int arg4) { GL42.glDrawElementsInstancedBaseVertexBaseInstance(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawElementsInstancedBaseVertexBaseInstance(int arg0, ShortBuffer arg1, int arg2, int arg3, int arg4) { GL42.glDrawElementsInstancedBaseVertexBaseInstance(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawElementsInstancedBaseVertexBaseInstance(int arg0, IntBuffer arg1, int arg2, int arg3, int arg4) { GL42.glDrawElementsInstancedBaseVertexBaseInstance(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawArraysInstancedBaseInstance(int arg0, int arg1, int arg2, int arg3, int arg4) { GL42.glDrawArraysInstancedBaseInstance(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetFloat(int arg0, int arg1, FloatBuffer arg2) { GL41.glGetFloat(arg0, arg1, arg2) }

	public static float glGetFloat(int arg0, int arg1) { GL41.glGetFloat(arg0, arg1) }

	public static void glGetDouble(int arg0, int arg1, DoubleBuffer arg2) { GL41.glGetDouble(arg0, arg1, arg2) }

	public static double glGetDouble(int arg0, int arg1) { GL41.glGetDouble(arg0, arg1) }

	public static void glShaderBinary(IntBuffer arg0, int arg1, ByteBuffer arg2) { GL41.glShaderBinary(arg0, arg1, arg2) }

	public static void glDepthRangef(float arg0, float arg1) { GL41.glDepthRangef(arg0, arg1) }

	public static void glProgramBinary(int arg0, int arg1, ByteBuffer arg2) { GL41.glProgramBinary(arg0, arg1, arg2) }

	public static void glClearDepthf(float arg0) { GL41.glClearDepthf(arg0) }

	public static int glGenProgramPipelines() { GL41.glGenProgramPipelines() }

	public static void glGenProgramPipelines(IntBuffer arg0) { GL41.glGenProgramPipelines(arg0) }

	public static void glActiveShaderProgram(int arg0, int arg1) { GL41.glActiveShaderProgram(arg0, arg1) }

	public static void glReleaseShaderCompiler() { GL41.glReleaseShaderCompiler() }

	public static void glProgramParameteri(int arg0, int arg1, int arg2) { GL41.glProgramParameteri(arg0, arg1, arg2) }

	public static void glUseProgramStages(int arg0, int arg1, int arg2) { GL41.glUseProgramStages(arg0, arg1, arg2) }

	public static void glGetShaderPrecisionFormat(int arg0, int arg1, IntBuffer arg2, IntBuffer arg3) { GL41.glGetShaderPrecisionFormat(arg0, arg1, arg2, arg3) }

	public static int glCreateShaderProgram(int arg0, CharSequence[] arg1) { GL41.glCreateShaderProgram(arg0, arg1) }

	public static int glCreateShaderProgram(int arg0, int arg1, ByteBuffer arg2) { GL41.glCreateShaderProgram(arg0, arg1, arg2) }

	public static int glCreateShaderProgram(int arg0, ByteBuffer arg1) { GL41.glCreateShaderProgram(arg0, arg1) }

	public static int glCreateShaderProgram(int arg0, ByteBuffer[] arg1) { GL41.glCreateShaderProgram(arg0, arg1) }

	public static int glCreateShaderProgram(int arg0, CharSequence arg1) { GL41.glCreateShaderProgram(arg0, arg1) }

	public static void glGetProgramBinary(int arg0, IntBuffer arg1, IntBuffer arg2, ByteBuffer arg3) { GL41.glGetProgramBinary(arg0, arg1, arg2, arg3) }

	public static void glBindProgramPipeline(int arg0) { GL41.glBindProgramPipeline(arg0) }

	public static void glDeleteProgramPipelines(int arg0) { GL41.glDeleteProgramPipelines(arg0) }

	public static void glDeleteProgramPipelines(IntBuffer arg0) { GL41.glDeleteProgramPipelines(arg0) }

	public static void glProgramUniform4(int arg0, int arg1, FloatBuffer arg2) { GL41.glProgramUniform4(arg0, arg1, arg2) }

	public static void glProgramUniform4(int arg0, int arg1, DoubleBuffer arg2) { GL41.glProgramUniform4(arg0, arg1, arg2) }

	public static void glProgramUniform4(int arg0, int arg1, IntBuffer arg2) { GL41.glProgramUniform4(arg0, arg1, arg2) }

	public static void glProgramUniform1f(int arg0, int arg1, float arg2) { GL41.glProgramUniform1f(arg0, arg1, arg2) }

	public static void glProgramUniform1(int arg0, int arg1, DoubleBuffer arg2) { GL41.glProgramUniform1(arg0, arg1, arg2) }

	public static void glProgramUniform1(int arg0, int arg1, IntBuffer arg2) { GL41.glProgramUniform1(arg0, arg1, arg2) }

	public static void glProgramUniform1(int arg0, int arg1, FloatBuffer arg2) { GL41.glProgramUniform1(arg0, arg1, arg2) }

	public static void glProgramUniform4i(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) { GL41.glProgramUniform4i(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static boolean glIsProgramPipeline(int arg0) { GL41.glIsProgramPipeline(arg0) }

	public static void glProgramUniform1i(int arg0, int arg1, int arg2) { GL41.glProgramUniform1i(arg0, arg1, arg2) }

	public static void glProgramUniform2i(int arg0, int arg1, int arg2, int arg3) { GL41.glProgramUniform2i(arg0, arg1, arg2, arg3) }

	public static void glProgramUniform3i(int arg0, int arg1, int arg2, int arg3, int arg4) { GL41.glProgramUniform3i(arg0, arg1, arg2, arg3, arg4) }

	public static void glProgramUniform2f(int arg0, int arg1, float arg2, float arg3) { GL41.glProgramUniform2f(arg0, arg1, arg2, arg3) }

	public static void glProgramUniform4d(int arg0, int arg1, double arg2, double arg3, double arg4, double arg5) { GL41.glProgramUniform4d(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glProgramUniform3(int arg0, int arg1, FloatBuffer arg2) { GL41.glProgramUniform3(arg0, arg1, arg2) }

	public static void glProgramUniform3(int arg0, int arg1, IntBuffer arg2) { GL41.glProgramUniform3(arg0, arg1, arg2) }

	public static void glProgramUniform3(int arg0, int arg1, DoubleBuffer arg2) { GL41.glProgramUniform3(arg0, arg1, arg2) }

	public static void glGetProgramPipeline(int arg0, int arg1, IntBuffer arg2) { GL41.glGetProgramPipeline(arg0, arg1, arg2) }

	public static void glProgramUniform2d(int arg0, int arg1, double arg2, double arg3) { GL41.glProgramUniform2d(arg0, arg1, arg2, arg3) }

	public static int glGetProgramPipelinei(int arg0, int arg1) { GL41.glGetProgramPipelinei(arg0, arg1) }

	public static void glProgramUniform3d(int arg0, int arg1, double arg2, double arg3, double arg4) { GL41.glProgramUniform3d(arg0, arg1, arg2, arg3, arg4) }

	public static void glProgramUniform4f(int arg0, int arg1, float arg2, float arg3, float arg4, float arg5) { GL41.glProgramUniform4f(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glProgramUniform3f(int arg0, int arg1, float arg2, float arg3, float arg4) { GL41.glProgramUniform3f(arg0, arg1, arg2, arg3, arg4) }

	public static void glProgramUniform1d(int arg0, int arg1, double arg2) { GL41.glProgramUniform1d(arg0, arg1, arg2) }

	public static void glProgramUniform2(int arg0, int arg1, IntBuffer arg2) { GL41.glProgramUniform2(arg0, arg1, arg2) }

	public static void glProgramUniform2(int arg0, int arg1, DoubleBuffer arg2) { GL41.glProgramUniform2(arg0, arg1, arg2) }

	public static void glProgramUniform2(int arg0, int arg1, FloatBuffer arg2) { GL41.glProgramUniform2(arg0, arg1, arg2) }

	public static void glVertexAttribL4(int arg0, DoubleBuffer arg1) { GL41.glVertexAttribL4(arg0, arg1) }

	public static void glScissorIndexed(int arg0, int arg1, int arg2, int arg3, int arg4) { GL41.glScissorIndexed(arg0, arg1, arg2, arg3, arg4) }

	public static void glScissorIndexed(int arg0, IntBuffer arg1) { GL41.glScissorIndexed(arg0, arg1) }

	public static void glVertexAttribL3(int arg0, DoubleBuffer arg1) { GL41.glVertexAttribL3(arg0, arg1) }

	public static void glVertexAttribL2(int arg0, DoubleBuffer arg1) { GL41.glVertexAttribL2(arg0, arg1) }

	public static void glVertexAttribL1(int arg0, DoubleBuffer arg1) { GL41.glVertexAttribL1(arg0, arg1) }

	public static void glScissorArray(int arg0, IntBuffer arg1) { GL41.glScissorArray(arg0, arg1) }

	public static void glViewportArray(int arg0, FloatBuffer arg1) { GL41.glViewportArray(arg0, arg1) }

	public static void glProgramUniformMatrix2x3(int arg0, int arg1, boolean arg2, FloatBuffer arg3) { GL41.glProgramUniformMatrix2x3(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix2x3(int arg0, int arg1, boolean arg2, DoubleBuffer arg3) { GL41.glProgramUniformMatrix2x3(arg0, arg1, arg2, arg3) }

	public static void glVertexAttribL3d(int arg0, double arg1, double arg2, double arg3) { GL41.glVertexAttribL3d(arg0, arg1, arg2, arg3) }

	public static void glGetProgramPipelineInfoLog(int arg0, IntBuffer arg1, ByteBuffer arg2) { GL41.glGetProgramPipelineInfoLog(arg0, arg1, arg2) }

	public static String glGetProgramPipelineInfoLog(int arg0, int arg1) { GL41.glGetProgramPipelineInfoLog(arg0, arg1) }

	public static void glProgramUniformMatrix2x4(int arg0, int arg1, boolean arg2, FloatBuffer arg3) { GL41.glProgramUniformMatrix2x4(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix2x4(int arg0, int arg1, boolean arg2, DoubleBuffer arg3) { GL41.glProgramUniformMatrix2x4(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix3(int arg0, int arg1, boolean arg2, FloatBuffer arg3) { GL41.glProgramUniformMatrix3(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix3(int arg0, int arg1, boolean arg2, DoubleBuffer arg3) { GL41.glProgramUniformMatrix3(arg0, arg1, arg2, arg3) }

	public static void glProgramUniform2u(int arg0, int arg1, IntBuffer arg2) { GL41.glProgramUniform2u(arg0, arg1, arg2) }

	public static void glProgramUniform4u(int arg0, int arg1, IntBuffer arg2) { GL41.glProgramUniform4u(arg0, arg1, arg2) }

	public static void glProgramUniformMatrix4x2(int arg0, int arg1, boolean arg2, FloatBuffer arg3) { GL41.glProgramUniformMatrix4x2(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix4x2(int arg0, int arg1, boolean arg2, DoubleBuffer arg3) { GL41.glProgramUniformMatrix4x2(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix4x3(int arg0, int arg1, boolean arg2, FloatBuffer arg3) { GL41.glProgramUniformMatrix4x3(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix4x3(int arg0, int arg1, boolean arg2, DoubleBuffer arg3) { GL41.glProgramUniformMatrix4x3(arg0, arg1, arg2, arg3) }

	public static void glProgramUniform1u(int arg0, int arg1, IntBuffer arg2) { GL41.glProgramUniform1u(arg0, arg1, arg2) }

	public static void glProgramUniform4ui(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) { GL41.glProgramUniform4ui(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glProgramUniform3ui(int arg0, int arg1, int arg2, int arg3, int arg4) { GL41.glProgramUniform3ui(arg0, arg1, arg2, arg3, arg4) }

	public static void glProgramUniform1ui(int arg0, int arg1, int arg2) { GL41.glProgramUniform1ui(arg0, arg1, arg2) }

	public static void glProgramUniformMatrix4(int arg0, int arg1, boolean arg2, FloatBuffer arg3) { GL41.glProgramUniformMatrix4(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix4(int arg0, int arg1, boolean arg2, DoubleBuffer arg3) { GL41.glProgramUniformMatrix4(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix3x2(int arg0, int arg1, boolean arg2, DoubleBuffer arg3) { GL41.glProgramUniformMatrix3x2(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix3x2(int arg0, int arg1, boolean arg2, FloatBuffer arg3) { GL41.glProgramUniformMatrix3x2(arg0, arg1, arg2, arg3) }

	public static void glVertexAttribL1d(int arg0, double arg1) { GL41.glVertexAttribL1d(arg0, arg1) }

	public static void glProgramUniform3u(int arg0, int arg1, IntBuffer arg2) { GL41.glProgramUniform3u(arg0, arg1, arg2) }

	public static void glVertexAttribL2d(int arg0, double arg1, double arg2) { GL41.glVertexAttribL2d(arg0, arg1, arg2) }

	public static void glProgramUniform2ui(int arg0, int arg1, int arg2, int arg3) { GL41.glProgramUniform2ui(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix2(int arg0, int arg1, boolean arg2, DoubleBuffer arg3) { GL41.glProgramUniformMatrix2(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix2(int arg0, int arg1, boolean arg2, FloatBuffer arg3) { GL41.glProgramUniformMatrix2(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix3x4(int arg0, int arg1, boolean arg2, DoubleBuffer arg3) { GL41.glProgramUniformMatrix3x4(arg0, arg1, arg2, arg3) }

	public static void glProgramUniformMatrix3x4(int arg0, int arg1, boolean arg2, FloatBuffer arg3) { GL41.glProgramUniformMatrix3x4(arg0, arg1, arg2, arg3) }

	public static void glValidateProgramPipeline(int arg0) { GL41.glValidateProgramPipeline(arg0) }

	public static void glVertexAttribL4d(int arg0, double arg1, double arg2, double arg3, double arg4) { GL41.glVertexAttribL4d(arg0, arg1, arg2, arg3, arg4) }

	public static void glDepthRangeIndexed(int arg0, double arg1, double arg2) { GL41.glDepthRangeIndexed(arg0, arg1, arg2) }

	public static void glVertexAttribLPointer(int arg0, int arg1, int arg2, DoubleBuffer arg3) { GL41.glVertexAttribLPointer(arg0, arg1, arg2, arg3) }

	public static void glVertexAttribLPointer(int arg0, int arg1, int arg2, long arg3) { GL41.glVertexAttribLPointer(arg0, arg1, arg2, arg3) }

	public static void glGetVertexAttribL(int arg0, int arg1, DoubleBuffer arg2) { GL41.glGetVertexAttribL(arg0, arg1, arg2) }

	public static void glViewportIndexed(int arg0, FloatBuffer arg1) { GL41.glViewportIndexed(arg0, arg1) }

	public static void glDepthRangeArray(int arg0, DoubleBuffer arg1) { GL41.glDepthRangeArray(arg0, arg1) }

	public static void glViewportIndexedf(int arg0, float arg1, float arg2, float arg3, float arg4) { GL41.glViewportIndexedf(arg0, arg1, arg2, arg3, arg4) }

	public static void glUniform1d(int arg0, double arg1) { GL40.glUniform1d(arg0, arg1) }

	public static void glGetUniform(int arg0, int arg1, DoubleBuffer arg2) { GL40.glGetUniform(arg0, arg1, arg2) }

	public static void glBlendFunci(int arg0, int arg1, int arg2) { GL40.glBlendFunci(arg0, arg1, arg2) }

	public static void glUniform1(int arg0, DoubleBuffer arg1) { GL40.glUniform1(arg0, arg1) }

	public static void glUniform4(int arg0, DoubleBuffer arg1) { GL40.glUniform4(arg0, arg1) }

	public static void glPatchParameter(int arg0, FloatBuffer arg1) { GL40.glPatchParameter(arg0, arg1) }

	public static void glUniform3(int arg0, DoubleBuffer arg1) { GL40.glUniform3(arg0, arg1) }

	public static void glUniform3d(int arg0, double arg1, double arg2, double arg3) { GL40.glUniform3d(arg0, arg1, arg2, arg3) }

	public static void glUniform2(int arg0, DoubleBuffer arg1) { GL40.glUniform2(arg0, arg1) }

	public static void glUniformMatrix4(int arg0, boolean arg1, DoubleBuffer arg2) { GL40.glUniformMatrix4(arg0, arg1, arg2) }

	public static void glUniform4d(int arg0, double arg1, double arg2, double arg3, double arg4) { GL40.glUniform4d(arg0, arg1, arg2, arg3, arg4) }

	public static void glUniformMatrix2(int arg0, boolean arg1, DoubleBuffer arg2) { GL40.glUniformMatrix2(arg0, arg1, arg2) }

	public static void glUniformMatrix3(int arg0, boolean arg1, DoubleBuffer arg2) { GL40.glUniformMatrix3(arg0, arg1, arg2) }

	public static void glUniform2d(int arg0, double arg1, double arg2) { GL40.glUniform2d(arg0, arg1, arg2) }

	public static void glBlendEquationi(int arg0, int arg1) { GL40.glBlendEquationi(arg0, arg1) }

	public static void glUniformMatrix3x4(int arg0, boolean arg1, DoubleBuffer arg2) { GL40.glUniformMatrix3x4(arg0, arg1, arg2) }

	public static void glDeleteTransformFeedbacks(IntBuffer arg0) { GL40.glDeleteTransformFeedbacks(arg0) }

	public static void glDeleteTransformFeedbacks(int arg0) { GL40.glDeleteTransformFeedbacks(arg0) }

	public static void glUniformMatrix3x2(int arg0, boolean arg1, DoubleBuffer arg2) { GL40.glUniformMatrix3x2(arg0, arg1, arg2) }

	public static int glGetUniformSubroutineui(int arg0, int arg1) { GL40.glGetUniformSubroutineui(arg0, arg1) }

	public static void glGetProgramStage(int arg0, int arg1, int arg2, IntBuffer arg3) { GL40.glGetProgramStage(arg0, arg1, arg2, arg3) }

	public static int glGetProgramStage(int arg0, int arg1, int arg2) { GL40.glGetProgramStage(arg0, arg1, arg2) }

	public static boolean glIsTransformFeedback(int arg0) { GL40.glIsTransformFeedback(arg0) }

	public static int glGetSubroutineUniformLocation(int arg0, int arg1, ByteBuffer arg2) { GL40.glGetSubroutineUniformLocation(arg0, arg1, arg2) }

	public static int glGetSubroutineUniformLocation(int arg0, int arg1, CharSequence arg2) { GL40.glGetSubroutineUniformLocation(arg0, arg1, arg2) }

	public static void glBlendFuncSeparatei(int arg0, int arg1, int arg2, int arg3, int arg4) { GL40.glBlendFuncSeparatei(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawElementsIndirect(int arg0, int arg1, IntBuffer arg2) { GL40.glDrawElementsIndirect(arg0, arg1, arg2) }

	public static void glDrawElementsIndirect(int arg0, int arg1, long arg2) { GL40.glDrawElementsIndirect(arg0, arg1, arg2) }

	public static void glDrawElementsIndirect(int arg0, int arg1, ByteBuffer arg2) { GL40.glDrawElementsIndirect(arg0, arg1, arg2) }

	public static void glDrawArraysIndirect(int arg0, IntBuffer arg1) { GL40.glDrawArraysIndirect(arg0, arg1) }

	public static void glDrawArraysIndirect(int arg0, long arg1) { GL40.glDrawArraysIndirect(arg0, arg1) }

	public static void glDrawArraysIndirect(int arg0, ByteBuffer arg1) { GL40.glDrawArraysIndirect(arg0, arg1) }

	public static void glMinSampleShading(float arg0) { GL40.glMinSampleShading(arg0) }

	public static void glBlendEquationSeparatei(int arg0, int arg1, int arg2) { GL40.glBlendEquationSeparatei(arg0, arg1, arg2) }

	public static int glGetActiveSubroutineUniform(int arg0, int arg1, int arg2, int arg3) { GL40.glGetActiveSubroutineUniform(arg0, arg1, arg2, arg3) }

	public static void glGetActiveSubroutineUniform(int arg0, int arg1, int arg2, int arg3, IntBuffer arg4) { GL40.glGetActiveSubroutineUniform(arg0, arg1, arg2, arg3, arg4) }

	public static int glGetActiveSubroutineUniformi(int arg0, int arg1, int arg2, int arg3) { GL40.glGetActiveSubroutineUniformi(arg0, arg1, arg2, arg3) }

	public static void glUniformSubroutinesu(int arg0, IntBuffer arg1) { GL40.glUniformSubroutinesu(arg0, arg1) }

	public static void glUniformMatrix4x3(int arg0, boolean arg1, DoubleBuffer arg2) { GL40.glUniformMatrix4x3(arg0, arg1, arg2) }

	public static void glPatchParameteri(int arg0, int arg1) { GL40.glPatchParameteri(arg0, arg1) }

	public static int glGenTransformFeedbacks() { GL40.glGenTransformFeedbacks() }

	public static void glGenTransformFeedbacks(IntBuffer arg0) { GL40.glGenTransformFeedbacks(arg0) }

	public static void glUniformMatrix4x2(int arg0, boolean arg1, DoubleBuffer arg2) { GL40.glUniformMatrix4x2(arg0, arg1, arg2) }

	public static int glGetSubroutineIndex(int arg0, int arg1, CharSequence arg2) { GL40.glGetSubroutineIndex(arg0, arg1, arg2) }

	public static int glGetSubroutineIndex(int arg0, int arg1, ByteBuffer arg2) { GL40.glGetSubroutineIndex(arg0, arg1, arg2) }

	public static void glGetActiveSubroutineName(int arg0, int arg1, int arg2, IntBuffer arg3, ByteBuffer arg4) { GL40.glGetActiveSubroutineName(arg0, arg1, arg2, arg3, arg4) }

	public static String glGetActiveSubroutineName(int arg0, int arg1, int arg2, int arg3) { GL40.glGetActiveSubroutineName(arg0, arg1, arg2, arg3) }

	public static int glGetProgramStagei(int arg0, int arg1, int arg2) { GL40.glGetProgramStagei(arg0, arg1, arg2) }

	public static void glBindTransformFeedback(int arg0, int arg1) { GL40.glBindTransformFeedback(arg0, arg1) }

	public static void glResumeTransformFeedback() { GL40.glResumeTransformFeedback() }

	public static void glGetUniformSubroutineu(int arg0, int arg1, IntBuffer arg2) { GL40.glGetUniformSubroutineu(arg0, arg1, arg2) }

	public static int glGetUniformSubroutineu(int arg0, int arg1) { GL40.glGetUniformSubroutineu(arg0, arg1) }

	public static void glPauseTransformFeedback() { GL40.glPauseTransformFeedback() }

	public static void glDrawTransformFeedback(int arg0, int arg1) { GL40.glDrawTransformFeedback(arg0, arg1) }

	public static void glUniformMatrix2x4(int arg0, boolean arg1, DoubleBuffer arg2) { GL40.glUniformMatrix2x4(arg0, arg1, arg2) }

	public static String glGetActiveSubroutineUniformName(int arg0, int arg1, int arg2, int arg3) { GL40.glGetActiveSubroutineUniformName(arg0, arg1, arg2, arg3) }

	public static void glGetActiveSubroutineUniformName(int arg0, int arg1, int arg2, IntBuffer arg3, ByteBuffer arg4) { GL40.glGetActiveSubroutineUniformName(arg0, arg1, arg2, arg3, arg4) }

	public static void glUniformMatrix2x3(int arg0, boolean arg1, DoubleBuffer arg2) { GL40.glUniformMatrix2x3(arg0, arg1, arg2) }

	public static int glGetQueryIndexedi(int arg0, int arg1, int arg2) { GL40.glGetQueryIndexedi(arg0, arg1, arg2) }

	public static void glDrawTransformFeedbackStream(int arg0, int arg1, int arg2) { GL40.glDrawTransformFeedbackStream(arg0, arg1, arg2) }

	public static void glBeginQueryIndexed(int arg0, int arg1, int arg2) { GL40.glBeginQueryIndexed(arg0, arg1, arg2) }

	public static void glEndQueryIndexed(int arg0, int arg1) { GL40.glEndQueryIndexed(arg0, arg1) }

	public static int glGetQueryIndexed(int arg0, int arg1, int arg2) { GL40.glGetQueryIndexed(arg0, arg1, arg2) }

	public static void glGetQueryIndexed(int arg0, int arg1, int arg2, IntBuffer arg3) { GL40.glGetQueryIndexed(arg0, arg1, arg2, arg3) }

	public static void glBindSampler(int arg0, int arg1) { GL33.glBindSampler(arg0, arg1) }

	public static void glQueryCounter(int arg0, int arg1) { GL33.glQueryCounter(arg0, arg1) }

	public static void glDeleteSamplers(int arg0) { GL33.glDeleteSamplers(arg0) }

	public static void glDeleteSamplers(IntBuffer arg0) { GL33.glDeleteSamplers(arg0) }

	public static void glGetQueryObject(int arg0, int arg1, LongBuffer arg2) { GL33.glGetQueryObject(arg0, arg1, arg2) }

	public static long glGetQueryObject(int arg0, int arg1) { GL33.glGetQueryObject(arg0, arg1) }

	public static boolean glIsSampler(int arg0) { GL33.glIsSampler(arg0) }

	public static void glVertexP2ui(int arg0, int arg1) { GL33.glVertexP2ui(arg0, arg1) }

	public static void glGenSamplers(IntBuffer arg0) { GL33.glGenSamplers(arg0) }

	public static int glGenSamplers() { GL33.glGenSamplers() }

	public static void glColorP3u(int arg0, IntBuffer arg1) { GL33.glColorP3u(arg0, arg1) }

	public static void glTexCoordP3u(int arg0, IntBuffer arg1) { GL33.glTexCoordP3u(arg0, arg1) }

	public static void glVertexP3ui(int arg0, int arg1) { GL33.glVertexP3ui(arg0, arg1) }

	public static void glTexCoordP4u(int arg0, IntBuffer arg1) { GL33.glTexCoordP4u(arg0, arg1) }

	public static void glVertexP2u(int arg0, IntBuffer arg1) { GL33.glVertexP2u(arg0, arg1) }

	public static void glTexCoordP2ui(int arg0, int arg1) { GL33.glTexCoordP2ui(arg0, arg1) }

	public static void glColorP3ui(int arg0, int arg1) { GL33.glColorP3ui(arg0, arg1) }

	public static void glTexCoordP1ui(int arg0, int arg1) { GL33.glTexCoordP1ui(arg0, arg1) }

	public static void glVertexP4ui(int arg0, int arg1) { GL33.glVertexP4ui(arg0, arg1) }

	public static void glVertexP4u(int arg0, IntBuffer arg1) { GL33.glVertexP4u(arg0, arg1) }

	public static void glColorP4u(int arg0, IntBuffer arg1) { GL33.glColorP4u(arg0, arg1) }

	public static void glVertexP3u(int arg0, IntBuffer arg1) { GL33.glVertexP3u(arg0, arg1) }

	public static void glTexCoordP4ui(int arg0, int arg1) { GL33.glTexCoordP4ui(arg0, arg1) }

	public static void glTexCoordP3ui(int arg0, int arg1) { GL33.glTexCoordP3ui(arg0, arg1) }

	public static void glTexCoordP1u(int arg0, IntBuffer arg1) { GL33.glTexCoordP1u(arg0, arg1) }

	public static void glColorP4ui(int arg0, int arg1) { GL33.glColorP4ui(arg0, arg1) }

	public static void glNormalP3u(int arg0, IntBuffer arg1) { GL33.glNormalP3u(arg0, arg1) }

	public static void glNormalP3ui(int arg0, int arg1) { GL33.glNormalP3ui(arg0, arg1) }

	public static void glTexCoordP2u(int arg0, IntBuffer arg1) { GL33.glTexCoordP2u(arg0, arg1) }

	public static void glGetSamplerParameter(int arg0, int arg1, FloatBuffer arg2) { GL33.glGetSamplerParameter(arg0, arg1, arg2) }

	public static void glGetSamplerParameter(int arg0, int arg1, IntBuffer arg2) { GL33.glGetSamplerParameter(arg0, arg1, arg2) }

	public static void glMultiTexCoordP2ui(int arg0, int arg1, int arg2) { GL33.glMultiTexCoordP2ui(arg0, arg1, arg2) }

	public static void glBindFragDataLocationIndexed(int arg0, int arg1, int arg2, ByteBuffer arg3) { GL33.glBindFragDataLocationIndexed(arg0, arg1, arg2, arg3) }

	public static void glBindFragDataLocationIndexed(int arg0, int arg1, int arg2, CharSequence arg3) { GL33.glBindFragDataLocationIndexed(arg0, arg1, arg2, arg3) }

	public static int glGetFragDataIndex(int arg0, ByteBuffer arg1) { GL33.glGetFragDataIndex(arg0, arg1) }

	public static int glGetFragDataIndex(int arg0, CharSequence arg1) { GL33.glGetFragDataIndex(arg0, arg1) }

	public static void glMultiTexCoordP3ui(int arg0, int arg1, int arg2) { GL33.glMultiTexCoordP3ui(arg0, arg1, arg2) }

	public static void glMultiTexCoordP4ui(int arg0, int arg1, int arg2) { GL33.glMultiTexCoordP4ui(arg0, arg1, arg2) }

	public static void glSamplerParameterI(int arg0, int arg1, IntBuffer arg2) { GL33.glSamplerParameterI(arg0, arg1, arg2) }

	public static int glGetSamplerParameterIi(int arg0, int arg1) { GL33.glGetSamplerParameterIi(arg0, arg1) }

	public static void glSamplerParameter(int arg0, int arg1, FloatBuffer arg2) { GL33.glSamplerParameter(arg0, arg1, arg2) }

	public static void glSamplerParameter(int arg0, int arg1, IntBuffer arg2) { GL33.glSamplerParameter(arg0, arg1, arg2) }

	public static void glMultiTexCoordP1u(int arg0, int arg1, IntBuffer arg2) { GL33.glMultiTexCoordP1u(arg0, arg1, arg2) }

	public static void glGetSamplerParameterI(int arg0, int arg1, IntBuffer arg2) { GL33.glGetSamplerParameterI(arg0, arg1, arg2) }

	public static void glSamplerParameterf(int arg0, int arg1, float arg2) { GL33.glSamplerParameterf(arg0, arg1, arg2) }

	public static void glSamplerParameteri(int arg0, int arg1, int arg2) { GL33.glSamplerParameteri(arg0, arg1, arg2) }

	public static int glGetSamplerParameterIui(int arg0, int arg1) { GL33.glGetSamplerParameterIui(arg0, arg1) }

	public static long glGetQueryObjecti64(int arg0, int arg1) { GL33.glGetQueryObjecti64(arg0, arg1) }

	public static long glGetQueryObjectu(int arg0, int arg1) { GL33.glGetQueryObjectu(arg0, arg1) }

	public static void glGetQueryObjectu(int arg0, int arg1, LongBuffer arg2) { GL33.glGetQueryObjectu(arg0, arg1, arg2) }

	public static long glGetQueryObjectui64(int arg0, int arg1) { GL33.glGetQueryObjectui64(arg0, arg1) }

	public static float glGetSamplerParameterf(int arg0, int arg1) { GL33.glGetSamplerParameterf(arg0, arg1) }

	public static void glSamplerParameterIu(int arg0, int arg1, IntBuffer arg2) { GL33.glSamplerParameterIu(arg0, arg1, arg2) }

	public static void glVertexAttribDivisor(int arg0, int arg1) { GL33.glVertexAttribDivisor(arg0, arg1) }

	public static int glGetSamplerParameteri(int arg0, int arg1) { GL33.glGetSamplerParameteri(arg0, arg1) }

	public static void glGetSamplerParameterIu(int arg0, int arg1, IntBuffer arg2) { GL33.glGetSamplerParameterIu(arg0, arg1, arg2) }

	public static void glMultiTexCoordP1ui(int arg0, int arg1, int arg2) { GL33.glMultiTexCoordP1ui(arg0, arg1, arg2) }

	public static void glVertexAttribP2u(int arg0, int arg1, boolean arg2, IntBuffer arg3) { GL33.glVertexAttribP2u(arg0, arg1, arg2, arg3) }

	public static void glMultiTexCoordP2u(int arg0, int arg1, IntBuffer arg2) { GL33.glMultiTexCoordP2u(arg0, arg1, arg2) }

	public static void glVertexAttribP4ui(int arg0, int arg1, boolean arg2, int arg3) { GL33.glVertexAttribP4ui(arg0, arg1, arg2, arg3) }

	public static void glSecondaryColorP3ui(int arg0, int arg1) { GL33.glSecondaryColorP3ui(arg0, arg1) }

	public static void glVertexAttribP3ui(int arg0, int arg1, boolean arg2, int arg3) { GL33.glVertexAttribP3ui(arg0, arg1, arg2, arg3) }

	public static void glVertexAttribP1u(int arg0, int arg1, boolean arg2, IntBuffer arg3) { GL33.glVertexAttribP1u(arg0, arg1, arg2, arg3) }

	public static void glVertexAttribP1ui(int arg0, int arg1, boolean arg2, int arg3) { GL33.glVertexAttribP1ui(arg0, arg1, arg2, arg3) }

	public static void glVertexAttribP4u(int arg0, int arg1, boolean arg2, IntBuffer arg3) { GL33.glVertexAttribP4u(arg0, arg1, arg2, arg3) }

	public static void glSecondaryColorP3u(int arg0, IntBuffer arg1) { GL33.glSecondaryColorP3u(arg0, arg1) }

	public static void glMultiTexCoordP3u(int arg0, int arg1, IntBuffer arg2) { GL33.glMultiTexCoordP3u(arg0, arg1, arg2) }

	public static void glMultiTexCoordP4u(int arg0, int arg1, IntBuffer arg2) { GL33.glMultiTexCoordP4u(arg0, arg1, arg2) }

	public static void glVertexAttribP2ui(int arg0, int arg1, boolean arg2, int arg3) { GL33.glVertexAttribP2ui(arg0, arg1, arg2, arg3) }

	public static void glVertexAttribP3u(int arg0, int arg1, boolean arg2, IntBuffer arg3) { GL33.glVertexAttribP3u(arg0, arg1, arg2, arg3) }

	public static void glDrawElementsInstancedBaseVertex(int arg0, ShortBuffer arg1, int arg2, int arg3) { GL32.glDrawElementsInstancedBaseVertex(arg0, arg1, arg2, arg3) }

	public static void glDrawElementsInstancedBaseVertex(int arg0, IntBuffer arg1, int arg2, int arg3) { GL32.glDrawElementsInstancedBaseVertex(arg0, arg1, arg2, arg3) }

	public static void glDrawElementsInstancedBaseVertex(int arg0, ByteBuffer arg1, int arg2, int arg3) { GL32.glDrawElementsInstancedBaseVertex(arg0, arg1, arg2, arg3) }

	public static void glDrawElementsInstancedBaseVertex(int arg0, int arg1, int arg2, long arg3, int arg4, int arg5) { GL32.glDrawElementsInstancedBaseVertex(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static GLSync glFenceSync(int arg0, int arg1) { GL32.glFenceSync(arg0, arg1) }

	public static boolean glIsSync(GLSync arg0) { GL32.glIsSync(arg0) }

	public static void glGetSync(GLSync arg0, int arg1, IntBuffer arg2, IntBuffer arg3) { GL32.glGetSync(arg0, arg1, arg2, arg3) }

	public static int glGetSync(GLSync arg0, int arg1) { GL32.glGetSync(arg0, arg1) }

	public static void glSampleMaski(int arg0, int arg1) { GL32.glSampleMaski(arg0, arg1) }

	public static int glClientWaitSync(GLSync arg0, int arg1, long arg2) { GL32.glClientWaitSync(arg0, arg1, arg2) }

	public static void glGetInteger64(int arg0, LongBuffer arg1) { GL32.glGetInteger64(arg0, arg1) }

	public static long glGetInteger64(int arg0) { GL32.glGetInteger64(arg0) }

	public static long glGetInteger64(int arg0, int arg1) { GL32.glGetInteger64(arg0, arg1) }

	public static void glGetInteger64(int arg0, int arg1, LongBuffer arg2) { GL32.glGetInteger64(arg0, arg1, arg2) }

	public static int glGetSynci(GLSync arg0, int arg1) { GL32.glGetSynci(arg0, arg1) }

	public static void glGetMultisample(int arg0, int arg1, FloatBuffer arg2) { GL32.glGetMultisample(arg0, arg1, arg2) }

	public static void glDeleteSync(GLSync arg0) { GL32.glDeleteSync(arg0) }

	public static void glWaitSync(GLSync arg0, int arg1, long arg2) { GL32.glWaitSync(arg0, arg1, arg2) }

	public static void glTexImage3DMultisample(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6) { GL32.glTexImage3DMultisample(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static long glGetBufferParameter(int arg0, int arg1) { GL32.glGetBufferParameter(arg0, arg1) }

	public static void glGetBufferParameter(int arg0, int arg1, LongBuffer arg2) { GL32.glGetBufferParameter(arg0, arg1, arg2) }

	public static void glTexImage2DMultisample(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) { GL32.glTexImage2DMultisample(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glDrawRangeElementsBaseVertex(int arg0, int arg1, int arg2, int arg3, int arg4, long arg5, int arg6) { GL32.glDrawRangeElementsBaseVertex(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glDrawRangeElementsBaseVertex(int arg0, int arg1, int arg2, IntBuffer arg3, int arg4) { GL32.glDrawRangeElementsBaseVertex(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawRangeElementsBaseVertex(int arg0, int arg1, int arg2, ShortBuffer arg3, int arg4) { GL32.glDrawRangeElementsBaseVertex(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawRangeElementsBaseVertex(int arg0, int arg1, int arg2, ByteBuffer arg3, int arg4) { GL32.glDrawRangeElementsBaseVertex(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawElementsBaseVertex(int arg0, ShortBuffer arg1, int arg2) { GL32.glDrawElementsBaseVertex(arg0, arg1, arg2) }

	public static void glDrawElementsBaseVertex(int arg0, ByteBuffer arg1, int arg2) { GL32.glDrawElementsBaseVertex(arg0, arg1, arg2) }

	public static void glDrawElementsBaseVertex(int arg0, int arg1, int arg2, long arg3, int arg4) { GL32.glDrawElementsBaseVertex(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawElementsBaseVertex(int arg0, IntBuffer arg1, int arg2) { GL32.glDrawElementsBaseVertex(arg0, arg1, arg2) }

	public static void glFramebufferTexture(int arg0, int arg1, int arg2, int arg3) { GL32.glFramebufferTexture(arg0, arg1, arg2, arg3) }

	public static long glGetBufferParameteri64(int arg0, int arg1) { GL32.glGetBufferParameteri64(arg0, arg1) }

	public static void glProvokingVertex(int arg0) { GL32.glProvokingVertex(arg0) }

	public static void glTexBuffer(int arg0, int arg1, int arg2) { GL31.glTexBuffer(arg0, arg1, arg2) }

	public static void glCopyBufferSubData(int arg0, int arg1, long arg2, long arg3, long arg4) { GL31.glCopyBufferSubData(arg0, arg1, arg2, arg3, arg4) }

	public static void glUniformBlockBinding(int arg0, int arg1, int arg2) { GL31.glUniformBlockBinding(arg0, arg1, arg2) }

	public static int glGetActiveUniformsi(int arg0, int arg1, int arg2) { GL31.glGetActiveUniformsi(arg0, arg1, arg2) }

	public static void glDrawArraysInstanced(int arg0, int arg1, int arg2, int arg3) { GL31.glDrawArraysInstanced(arg0, arg1, arg2, arg3) }

	public static int glGetUniformBlockIndex(int arg0, ByteBuffer arg1) { GL31.glGetUniformBlockIndex(arg0, arg1) }

	public static int glGetUniformBlockIndex(int arg0, CharSequence arg1) { GL31.glGetUniformBlockIndex(arg0, arg1) }

	public static void glGetActiveUniforms(int arg0, IntBuffer arg1, int arg2, IntBuffer arg3) { GL31.glGetActiveUniforms(arg0, arg1, arg2, arg3) }

	public static int glGetActiveUniforms(int arg0, int arg1, int arg2) { GL31.glGetActiveUniforms(arg0, arg1, arg2) }

	public static int glGetActiveUniformBlocki(int arg0, int arg1, int arg2) { GL31.glGetActiveUniformBlocki(arg0, arg1, arg2) }

	public static String glGetActiveUniformName(int arg0, int arg1, int arg2) { GL31.glGetActiveUniformName(arg0, arg1, arg2) }

	public static void glGetActiveUniformName(int arg0, int arg1, IntBuffer arg2, ByteBuffer arg3) { GL31.glGetActiveUniformName(arg0, arg1, arg2, arg3) }

	public static void glPrimitiveRestartIndex(int arg0) { GL31.glPrimitiveRestartIndex(arg0) }

	public static void glGetActiveUniformBlockName(int arg0, int arg1, IntBuffer arg2, ByteBuffer arg3) { GL31.glGetActiveUniformBlockName(arg0, arg1, arg2, arg3) }

	public static String glGetActiveUniformBlockName(int arg0, int arg1, int arg2) { GL31.glGetActiveUniformBlockName(arg0, arg1, arg2) }

	public static void glDrawElementsInstanced(int arg0, int arg1, int arg2, long arg3, int arg4) { GL31.glDrawElementsInstanced(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawElementsInstanced(int arg0, ShortBuffer arg1, int arg2) { GL31.glDrawElementsInstanced(arg0, arg1, arg2) }

	public static void glDrawElementsInstanced(int arg0, IntBuffer arg1, int arg2) { GL31.glDrawElementsInstanced(arg0, arg1, arg2) }

	public static void glDrawElementsInstanced(int arg0, ByteBuffer arg1, int arg2) { GL31.glDrawElementsInstanced(arg0, arg1, arg2) }

	public static void glGetUniformIndices(int arg0, ByteBuffer arg1, IntBuffer arg2) { GL31.glGetUniformIndices(arg0, arg1, arg2) }

	public static void glGetUniformIndices(int arg0, CharSequence[] arg1, IntBuffer arg2) { GL31.glGetUniformIndices(arg0, arg1, arg2) }

	public static void glGetActiveUniformBlock(int arg0, int arg1, int arg2, IntBuffer arg3) { GL31.glGetActiveUniformBlock(arg0, arg1, arg2, arg3) }

	public static int glGetActiveUniformBlock(int arg0, int arg1, int arg2) { GL31.glGetActiveUniformBlock(arg0, arg1, arg2) }

	public static boolean glGetBoolean(int arg0, int arg1) { GL30.glGetBoolean(arg0, arg1) }

	public static void glGetBoolean(int arg0, int arg1, ByteBuffer arg2) { GL30.glGetBoolean(arg0, arg1, arg2) }

	public static void glGetInteger(int arg0, int arg1, IntBuffer arg2) { GL30.glGetInteger(arg0, arg1, arg2) }

	public static int glGetInteger(int arg0, int arg1) { GL30.glGetInteger(arg0, arg1) }

	public static int glGetFramebufferAttachmentParameter(int arg0, int arg1, int arg2) { GL30.glGetFramebufferAttachmentParameter(arg0, arg1, arg2) }

	public static void glGetFramebufferAttachmentParameter(int arg0, int arg1, int arg2, IntBuffer arg3) { GL30.glGetFramebufferAttachmentParameter(arg0, arg1, arg2, arg3) }

	public static int glGetFramebufferAttachmentParameteri(int arg0, int arg1, int arg2) { GL30.glGetFramebufferAttachmentParameteri(arg0, arg1, arg2) }

	public static void glGetVertexAttribI(int arg0, int arg1, IntBuffer arg2) { GL30.glGetVertexAttribI(arg0, arg1, arg2) }

	public static void glEndConditionalRender() { GL30.glEndConditionalRender() }

	public static void glVertexAttribIPointer(int arg0, int arg1, int arg2, int arg3, ShortBuffer arg4) { GL30.glVertexAttribIPointer(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexAttribIPointer(int arg0, int arg1, int arg2, int arg3, IntBuffer arg4) { GL30.glVertexAttribIPointer(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexAttribIPointer(int arg0, int arg1, int arg2, int arg3, long arg4) { GL30.glVertexAttribIPointer(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexAttribIPointer(int arg0, int arg1, int arg2, int arg3, ByteBuffer arg4) { GL30.glVertexAttribIPointer(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexAttribI2i(int arg0, int arg1, int arg2) { GL30.glVertexAttribI2i(arg0, arg1, arg2) }

	public static void glVertexAttribI2u(int arg0, IntBuffer arg1) { GL30.glVertexAttribI2u(arg0, arg1) }

	public static void glVertexAttribI4i(int arg0, int arg1, int arg2, int arg3, int arg4) { GL30.glVertexAttribI4i(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexAttribI3ui(int arg0, int arg1, int arg2, int arg3) { GL30.glVertexAttribI3ui(arg0, arg1, arg2, arg3) }

	public static void glVertexAttribI1i(int arg0, int arg1) { GL30.glVertexAttribI1i(arg0, arg1) }

	public static void glVertexAttribI1ui(int arg0, int arg1) { GL30.glVertexAttribI1ui(arg0, arg1) }

	public static void glVertexAttribI3u(int arg0, IntBuffer arg1) { GL30.glVertexAttribI3u(arg0, arg1) }

	public static void glVertexAttribI4u(int arg0, ShortBuffer arg1) { GL30.glVertexAttribI4u(arg0, arg1) }

	public static void glVertexAttribI4u(int arg0, ByteBuffer arg1) { GL30.glVertexAttribI4u(arg0, arg1) }

	public static void glVertexAttribI4u(int arg0, IntBuffer arg1) { GL30.glVertexAttribI4u(arg0, arg1) }

	public static void glVertexAttribI3i(int arg0, int arg1, int arg2, int arg3) { GL30.glVertexAttribI3i(arg0, arg1, arg2, arg3) }

	public static void glVertexAttribI4ui(int arg0, int arg1, int arg2, int arg3, int arg4) { GL30.glVertexAttribI4ui(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetVertexAttribIu(int arg0, int arg1, IntBuffer arg2) { GL30.glGetVertexAttribIu(arg0, arg1, arg2) }

	public static void glBindFragDataLocation(int arg0, int arg1, CharSequence arg2) { GL30.glBindFragDataLocation(arg0, arg1, arg2) }

	public static void glBindFragDataLocation(int arg0, int arg1, ByteBuffer arg2) { GL30.glBindFragDataLocation(arg0, arg1, arg2) }

	public static int glGetFragDataLocation(int arg0, CharSequence arg1) { GL30.glGetFragDataLocation(arg0, arg1) }

	public static int glGetFragDataLocation(int arg0, ByteBuffer arg1) { GL30.glGetFragDataLocation(arg0, arg1) }

	public static void glBeginConditionalRender(int arg0, int arg1) { GL30.glBeginConditionalRender(arg0, arg1) }

	public static void glVertexAttribI2ui(int arg0, int arg1, int arg2) { GL30.glVertexAttribI2ui(arg0, arg1, arg2) }

	public static void glVertexAttribI1u(int arg0, IntBuffer arg1) { GL30.glVertexAttribI1u(arg0, arg1) }

	public static int glGetTexParameterIi(int arg0, int arg1) { GL30.glGetTexParameterIi(arg0, arg1) }

	public static void glGetTexParameterIu(int arg0, int arg1, IntBuffer arg2) { GL30.glGetTexParameterIu(arg0, arg1, arg2) }

	public static void glDeleteRenderbuffers(int arg0) { GL30.glDeleteRenderbuffers(arg0) }

	public static void glDeleteRenderbuffers(IntBuffer arg0) { GL30.glDeleteRenderbuffers(arg0) }

	public static void glFramebufferTexture1D(int arg0, int arg1, int arg2, int arg3, int arg4) { GL30.glFramebufferTexture1D(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetRenderbufferParameter(int arg0, int arg1, IntBuffer arg2) { GL30.glGetRenderbufferParameter(arg0, arg1, arg2) }

	public static int glGetRenderbufferParameter(int arg0, int arg1) { GL30.glGetRenderbufferParameter(arg0, arg1) }

	public static int glGetTexParameterIui(int arg0, int arg1) { GL30.glGetTexParameterIui(arg0, arg1) }

	public static void glRenderbufferStorage(int arg0, int arg1, int arg2, int arg3) { GL30.glRenderbufferStorage(arg0, arg1, arg2, arg3) }

	public static void glBindFramebuffer(int arg0, int arg1) { GL30.glBindFramebuffer(arg0, arg1) }

	public static void glGetTexParameterI(int arg0, int arg1, IntBuffer arg2) { GL30.glGetTexParameterI(arg0, arg1, arg2) }

	public static void glBindRenderbuffer(int arg0, int arg1) { GL30.glBindRenderbuffer(arg0, arg1) }

	public static void glGenRenderbuffers(IntBuffer arg0) { GL30.glGenRenderbuffers(arg0) }

	public static int glGenRenderbuffers() { GL30.glGenRenderbuffers() }

	public static void glEndTransformFeedback() { GL30.glEndTransformFeedback() }

	public static void glFramebufferTexture2D(int arg0, int arg1, int arg2, int arg3, int arg4) { GL30.glFramebufferTexture2D(arg0, arg1, arg2, arg3, arg4) }

	public static void glBeginTransformFeedback(int arg0) { GL30.glBeginTransformFeedback(arg0) }

	public static void glBindVertexArray(int arg0) { GL30.glBindVertexArray(arg0) }

	public static void glDeleteVertexArrays(IntBuffer arg0) { GL30.glDeleteVertexArrays(arg0) }

	public static void glDeleteVertexArrays(int arg0) { GL30.glDeleteVertexArrays(arg0) }

	public static int glGetRenderbufferParameteri(int arg0, int arg1) { GL30.glGetRenderbufferParameteri(arg0, arg1) }

	public static void glDeleteFramebuffers(IntBuffer arg0) { GL30.glDeleteFramebuffers(arg0) }

	public static void glDeleteFramebuffers(int arg0) { GL30.glDeleteFramebuffers(arg0) }

	public static void glFramebufferRenderbuffer(int arg0, int arg1, int arg2, int arg3) { GL30.glFramebufferRenderbuffer(arg0, arg1, arg2, arg3) }

	public static void glFramebufferTexture3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) { GL30.glFramebufferTexture3D(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glFramebufferTextureLayer(int arg0, int arg1, int arg2, int arg3, int arg4) { GL30.glFramebufferTextureLayer(arg0, arg1, arg2, arg3, arg4) }

	public static void glBindBufferRange(int arg0, int arg1, int arg2, long arg3, long arg4) { GL30.glBindBufferRange(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTransformFeedbackVarying(int arg0, int arg1, IntBuffer arg2, IntBuffer arg3, IntBuffer arg4, ByteBuffer arg5) { GL30.glGetTransformFeedbackVarying(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static String glGetTransformFeedbackVarying(int arg0, int arg1, int arg2, IntBuffer arg3, IntBuffer arg4) { GL30.glGetTransformFeedbackVarying(arg0, arg1, arg2, arg3, arg4) }

	public static void glTexParameterIui(int arg0, int arg1, int arg2) { GL30.glTexParameterIui(arg0, arg1, arg2) }

	public static void glFlushMappedBufferRange(int arg0, long arg1, long arg2) { GL30.glFlushMappedBufferRange(arg0, arg1, arg2) }

	public static void glTransformFeedbackVaryings(int arg0, int arg1, ByteBuffer arg2, int arg3) { GL30.glTransformFeedbackVaryings(arg0, arg1, arg2, arg3) }

	public static void glTransformFeedbackVaryings(int arg0, CharSequence[] arg1, int arg2) { GL30.glTransformFeedbackVaryings(arg0, arg1, arg2) }

	public static int glCheckFramebufferStatus(int arg0) { GL30.glCheckFramebufferStatus(arg0) }

	public static void glGenVertexArrays(IntBuffer arg0) { GL30.glGenVertexArrays(arg0) }

	public static int glGenVertexArrays() { GL30.glGenVertexArrays() }

	public static int glGenFramebuffers() { GL30.glGenFramebuffers() }

	public static void glGenFramebuffers(IntBuffer arg0) { GL30.glGenFramebuffers(arg0) }

	public static void glRenderbufferStorageMultisample(int arg0, int arg1, int arg2, int arg3, int arg4) { GL30.glRenderbufferStorageMultisample(arg0, arg1, arg2, arg3, arg4) }

	public static void glBlitFramebuffer(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) { GL30.glBlitFramebuffer(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static boolean glIsVertexArray(int arg0) { GL30.glIsVertexArray(arg0) }

	public static String glGetStringi(int arg0, int arg1) { GL30.glGetStringi(arg0, arg1) }

	public static void glTexParameterIu(int arg0, int arg1, IntBuffer arg2) { GL30.glTexParameterIu(arg0, arg1, arg2) }

	public static void glUniform3ui(int arg0, int arg1, int arg2, int arg3) { GL30.glUniform3ui(arg0, arg1, arg2, arg3) }

	public static void glVertexAttribI1(int arg0, IntBuffer arg1) { GL30.glVertexAttribI1(arg0, arg1) }

	public static void glUniform4ui(int arg0, int arg1, int arg2, int arg3, int arg4) { GL30.glUniform4ui(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexAttribI3(int arg0, IntBuffer arg1) { GL30.glVertexAttribI3(arg0, arg1) }

	public static void glEnablei(int arg0, int arg1) { GL30.glEnablei(arg0, arg1) }

	public static void glVertexAttribI4(int arg0, IntBuffer arg1) { GL30.glVertexAttribI4(arg0, arg1) }

	public static void glVertexAttribI4(int arg0, ShortBuffer arg1) { GL30.glVertexAttribI4(arg0, arg1) }

	public static void glVertexAttribI4(int arg0, ByteBuffer arg1) { GL30.glVertexAttribI4(arg0, arg1) }

	public static void glClampColor(int arg0, int arg1) { GL30.glClampColor(arg0, arg1) }

	public static void glGetUniformu(int arg0, int arg1, IntBuffer arg2) { GL30.glGetUniformu(arg0, arg1, arg2) }

	public static void glClearBuffer(int arg0, int arg1, FloatBuffer arg2) { GL30.glClearBuffer(arg0, arg1, arg2) }

	public static void glClearBuffer(int arg0, int arg1, IntBuffer arg2) { GL30.glClearBuffer(arg0, arg1, arg2) }

	public static void glDisablei(int arg0, int arg1) { GL30.glDisablei(arg0, arg1) }

	public static void glBindBufferBase(int arg0, int arg1, int arg2) { GL30.glBindBufferBase(arg0, arg1, arg2) }

	public static void glTexParameterI(int arg0, int arg1, IntBuffer arg2) { GL30.glTexParameterI(arg0, arg1, arg2) }

	public static void glGenerateMipmap(int arg0) { GL30.glGenerateMipmap(arg0) }

	public static void glUniform1ui(int arg0, int arg1) { GL30.glUniform1ui(arg0, arg1) }

	public static boolean glIsFramebuffer(int arg0) { GL30.glIsFramebuffer(arg0) }

	public static boolean glIsEnabledi(int arg0, int arg1) { GL30.glIsEnabledi(arg0, arg1) }

	public static void glVertexAttribI2(int arg0, IntBuffer arg1) { GL30.glVertexAttribI2(arg0, arg1) }

	public static void glClearBufferu(int arg0, int arg1, IntBuffer arg2) { GL30.glClearBufferu(arg0, arg1, arg2) }

	public static void glUniform4u(int arg0, IntBuffer arg1) { GL30.glUniform4u(arg0, arg1) }

	public static void glColorMaski(int arg0, boolean arg1, boolean arg2, boolean arg3, boolean arg4) { GL30.glColorMaski(arg0, arg1, arg2, arg3, arg4) }

	public static void glClearBufferfi(int arg0, int arg1, float arg2, int arg3) { GL30.glClearBufferfi(arg0, arg1, arg2, arg3) }

	public static void glUniform1u(int arg0, IntBuffer arg1) { GL30.glUniform1u(arg0, arg1) }

	public static void glUniform2u(int arg0, IntBuffer arg1) { GL30.glUniform2u(arg0, arg1) }

	public static void glUniform2ui(int arg0, int arg1, int arg2) { GL30.glUniform2ui(arg0, arg1, arg2) }

	public static void glUniform3u(int arg0, IntBuffer arg1) { GL30.glUniform3u(arg0, arg1) }

	public static ByteBuffer glMapBufferRange(int arg0, long arg1, long arg2, int arg3, ByteBuffer arg4) { GL30.glMapBufferRange(arg0, arg1, arg2, arg3, arg4) }

	public static boolean glIsRenderbuffer(int arg0) { GL30.glIsRenderbuffer(arg0) }

	public static void glTexParameterIi(int arg0, int arg1, int arg2) { GL30.glTexParameterIi(arg0, arg1, arg2) }

	public static void glUniformMatrix3x4(int arg0, boolean arg1, FloatBuffer arg2) { GL21.glUniformMatrix3x4(arg0, arg1, arg2) }

	public static void glUniformMatrix3x2(int arg0, boolean arg1, FloatBuffer arg2) { GL21.glUniformMatrix3x2(arg0, arg1, arg2) }

	public static void glUniformMatrix4x3(int arg0, boolean arg1, FloatBuffer arg2) { GL21.glUniformMatrix4x3(arg0, arg1, arg2) }

	public static void glUniformMatrix4x2(int arg0, boolean arg1, FloatBuffer arg2) { GL21.glUniformMatrix4x2(arg0, arg1, arg2) }

	public static void glUniformMatrix2x4(int arg0, boolean arg1, FloatBuffer arg2) { GL21.glUniformMatrix2x4(arg0, arg1, arg2) }

	public static void glUniformMatrix2x3(int arg0, boolean arg1, FloatBuffer arg2) { GL21.glUniformMatrix2x3(arg0, arg1, arg2) }

	public static void glGetActiveUniform(int arg0, int arg1, IntBuffer arg2, IntBuffer arg3, IntBuffer arg4, ByteBuffer arg5) { GL20.glGetActiveUniform(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static String glGetActiveUniform(int arg0, int arg1, int arg2, IntBuffer arg3) { GL20.glGetActiveUniform(arg0, arg1, arg2, arg3) }

	public static String glGetActiveUniform(int arg0, int arg1, int arg2) { GL20.glGetActiveUniform(arg0, arg1, arg2) }

	public static int glGetUniformLocation(int arg0, CharSequence arg1) { GL20.glGetUniformLocation(arg0, arg1) }

	public static int glGetUniformLocation(int arg0, ByteBuffer arg1) { GL20.glGetUniformLocation(arg0, arg1) }

	public static int glGetActiveUniformSize(int arg0, int arg1) { GL20.glGetActiveUniformSize(arg0, arg1) }

	public static void glEnableVertexAttribArray(int arg0) { GL20.glEnableVertexAttribArray(arg0) }

	public static void glGetAttachedShaders(int arg0, IntBuffer arg1, IntBuffer arg2) { GL20.glGetAttachedShaders(arg0, arg1, arg2) }

	public static int glGetActiveAttribSize(int arg0, int arg1) { GL20.glGetActiveAttribSize(arg0, arg1) }

	public static String glGetActiveAttrib(int arg0, int arg1, int arg2) { GL20.glGetActiveAttrib(arg0, arg1, arg2) }

	public static String glGetActiveAttrib(int arg0, int arg1, int arg2, IntBuffer arg3) { GL20.glGetActiveAttrib(arg0, arg1, arg2, arg3) }

	public static void glGetActiveAttrib(int arg0, int arg1, IntBuffer arg2, IntBuffer arg3, IntBuffer arg4, ByteBuffer arg5) { GL20.glGetActiveAttrib(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glVertexAttribPointer(int arg0, int arg1, boolean arg2, boolean arg3, int arg4, ByteBuffer arg5) { GL20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glVertexAttribPointer(int arg0, int arg1, boolean arg2, int arg3, FloatBuffer arg4) { GL20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexAttribPointer(int arg0, int arg1, boolean arg2, int arg3, DoubleBuffer arg4) { GL20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexAttribPointer(int arg0, int arg1, int arg2, boolean arg3, int arg4, ByteBuffer arg5) { GL20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glVertexAttribPointer(int arg0, int arg1, int arg2, boolean arg3, int arg4, long arg5) { GL20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glVertexAttribPointer(int arg0, int arg1, boolean arg2, boolean arg3, int arg4, IntBuffer arg5) { GL20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glVertexAttribPointer(int arg0, int arg1, boolean arg2, boolean arg3, int arg4, ShortBuffer arg5) { GL20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glDisableVertexAttribArray(int arg0) { GL20.glDisableVertexAttribArray(arg0) }

	public static void glGetVertexAttrib(int arg0, int arg1, FloatBuffer arg2) { GL20.glGetVertexAttrib(arg0, arg1, arg2) }

	public static void glGetVertexAttrib(int arg0, int arg1, DoubleBuffer arg2) { GL20.glGetVertexAttrib(arg0, arg1, arg2) }

	public static void glGetVertexAttrib(int arg0, int arg1, IntBuffer arg2) { GL20.glGetVertexAttrib(arg0, arg1, arg2) }

	public static void glVertexAttrib4Nub(int arg0, byte arg1, byte arg2, byte arg3, byte arg4) { GL20.glVertexAttrib4Nub(arg0, arg1, arg2, arg3, arg4) }

	public static void glBindAttribLocation(int arg0, int arg1, ByteBuffer arg2) { GL20.glBindAttribLocation(arg0, arg1, arg2) }

	public static void glBindAttribLocation(int arg0, int arg1, CharSequence arg2) { GL20.glBindAttribLocation(arg0, arg1, arg2) }

	public static int glGetActiveUniformType(int arg0, int arg1) { GL20.glGetActiveUniformType(arg0, arg1) }

	public static void glValidateProgram(int arg0) { GL20.glValidateProgram(arg0) }

	public static int glGetActiveAttribType(int arg0, int arg1) { GL20.glGetActiveAttribType(arg0, arg1) }

	public static int glGetAttribLocation(int arg0, CharSequence arg1) { GL20.glGetAttribLocation(arg0, arg1) }

	public static int glGetAttribLocation(int arg0, ByteBuffer arg1) { GL20.glGetAttribLocation(arg0, arg1) }

	public static void glStencilOpSeparate(int arg0, int arg1, int arg2, int arg3) { GL20.glStencilOpSeparate(arg0, arg1, arg2, arg3) }

	public static String glGetShaderSource(int arg0, int arg1) { GL20.glGetShaderSource(arg0, arg1) }

	public static void glGetShaderSource(int arg0, IntBuffer arg1, ByteBuffer arg2) { GL20.glGetShaderSource(arg0, arg1, arg2) }

	public static void glGetVertexAttribPointer(int arg0, int arg1, ByteBuffer arg2) { GL20.glGetVertexAttribPointer(arg0, arg1, arg2) }

	public static ByteBuffer glGetVertexAttribPointer(int arg0, int arg1, long arg2) { GL20.glGetVertexAttribPointer(arg0, arg1, arg2) }

	public static void glGetShaderInfoLog(int arg0, IntBuffer arg1, ByteBuffer arg2) { GL20.glGetShaderInfoLog(arg0, arg1, arg2) }

	public static String glGetShaderInfoLog(int arg0, int arg1) { GL20.glGetShaderInfoLog(arg0, arg1) }

	public static void glGetProgramInfoLog(int arg0, IntBuffer arg1, ByteBuffer arg2) { GL20.glGetProgramInfoLog(arg0, arg1, arg2) }

	public static String glGetProgramInfoLog(int arg0, int arg1) { GL20.glGetProgramInfoLog(arg0, arg1) }

	public static void glBlendEquationSeparate(int arg0, int arg1) { GL20.glBlendEquationSeparate(arg0, arg1) }

	public static void glStencilMaskSeparate(int arg0, int arg1) { GL20.glStencilMaskSeparate(arg0, arg1) }

	public static void glStencilFuncSeparate(int arg0, int arg1, int arg2, int arg3) { GL20.glStencilFuncSeparate(arg0, arg1, arg2, arg3) }

	public static void glGetUniform(int arg0, int arg1, FloatBuffer arg2) { GL20.glGetUniform(arg0, arg1, arg2) }

	public static void glGetUniform(int arg0, int arg1, IntBuffer arg2) { GL20.glGetUniform(arg0, arg1, arg2) }

	public static void glUniform1(int arg0, FloatBuffer arg1) { GL20.glUniform1(arg0, arg1) }

	public static void glUniform1(int arg0, IntBuffer arg1) { GL20.glUniform1(arg0, arg1) }

	public static void glUniform4(int arg0, IntBuffer arg1) { GL20.glUniform4(arg0, arg1) }

	public static void glUniform4(int arg0, FloatBuffer arg1) { GL20.glUniform4(arg0, arg1) }

	public static void glUniform3(int arg0, FloatBuffer arg1) { GL20.glUniform3(arg0, arg1) }

	public static void glUniform3(int arg0, IntBuffer arg1) { GL20.glUniform3(arg0, arg1) }

	public static void glUniform2(int arg0, FloatBuffer arg1) { GL20.glUniform2(arg0, arg1) }

	public static void glUniform2(int arg0, IntBuffer arg1) { GL20.glUniform2(arg0, arg1) }

	public static void glUniformMatrix4(int arg0, boolean arg1, FloatBuffer arg2) { GL20.glUniformMatrix4(arg0, arg1, arg2) }

	public static void glUniformMatrix2(int arg0, boolean arg1, FloatBuffer arg2) { GL20.glUniformMatrix2(arg0, arg1, arg2) }

	public static void glUniformMatrix3(int arg0, boolean arg1, FloatBuffer arg2) { GL20.glUniformMatrix3(arg0, arg1, arg2) }

	public static void glVertexAttrib1f(int arg0, float arg1) { GL20.glVertexAttrib1f(arg0, arg1) }

	public static void glVertexAttrib3d(int arg0, double arg1, double arg2, double arg3) { GL20.glVertexAttrib3d(arg0, arg1, arg2, arg3) }

	public static void glVertexAttrib3s(int arg0, short arg1, short arg2, short arg3) { GL20.glVertexAttrib3s(arg0, arg1, arg2, arg3) }

	public static int glGetShader(int arg0, int arg1) { GL20.glGetShader(arg0, arg1) }

	public static void glGetShader(int arg0, int arg1, IntBuffer arg2) { GL20.glGetShader(arg0, arg1, arg2) }

	public static void glVertexAttrib1d(int arg0, double arg1) { GL20.glVertexAttrib1d(arg0, arg1) }

	public static void glVertexAttrib2f(int arg0, float arg1, float arg2) { GL20.glVertexAttrib2f(arg0, arg1, arg2) }

	public static void glVertexAttrib2d(int arg0, double arg1, double arg2) { GL20.glVertexAttrib2d(arg0, arg1, arg2) }

	public static void glVertexAttrib4d(int arg0, double arg1, double arg2, double arg3, double arg4) { GL20.glVertexAttrib4d(arg0, arg1, arg2, arg3, arg4) }

	public static int glGetProgrami(int arg0, int arg1) { GL20.glGetProgrami(arg0, arg1) }

	public static void glVertexAttrib2s(int arg0, short arg1, short arg2) { GL20.glVertexAttrib2s(arg0, arg1, arg2) }

	public static void glGetProgram(int arg0, int arg1, IntBuffer arg2) { GL20.glGetProgram(arg0, arg1, arg2) }

	public static int glGetProgram(int arg0, int arg1) { GL20.glGetProgram(arg0, arg1) }

	public static void glVertexAttrib1s(int arg0, short arg1) { GL20.glVertexAttrib1s(arg0, arg1) }

	public static void glVertexAttrib3f(int arg0, float arg1, float arg2, float arg3) { GL20.glVertexAttrib3f(arg0, arg1, arg2, arg3) }

	public static int glGetShaderi(int arg0, int arg1) { GL20.glGetShaderi(arg0, arg1) }

	public static void glDrawBuffers(int arg0) { GL20.glDrawBuffers(arg0) }

	public static void glDrawBuffers(IntBuffer arg0) { GL20.glDrawBuffers(arg0) }

	public static void glVertexAttrib4f(int arg0, float arg1, float arg2, float arg3, float arg4) { GL20.glVertexAttrib4f(arg0, arg1, arg2, arg3, arg4) }

	public static void glVertexAttrib4s(int arg0, short arg1, short arg2, short arg3, short arg4) { GL20.glVertexAttrib4s(arg0, arg1, arg2, arg3, arg4) }

	public static void glUseProgram(int arg0) { GL20.glUseProgram(arg0) }

	public static void glUniform4i(int arg0, int arg1, int arg2, int arg3, int arg4) { GL20.glUniform4i(arg0, arg1, arg2, arg3, arg4) }

	public static void glShaderSource(int arg0, ByteBuffer arg1) { GL20.glShaderSource(arg0, arg1) }

	public static void glShaderSource(int arg0, CharSequence arg1) { GL20.glShaderSource(arg0, arg1) }

	public static void glShaderSource(int arg0, CharSequence[] arg1) { GL20.glShaderSource(arg0, arg1) }

	public static void glUniform1f(int arg0, float arg1) { GL20.glUniform1f(arg0, arg1) }

	public static void glUniform3f(int arg0, float arg1, float arg2, float arg3) { GL20.glUniform3f(arg0, arg1, arg2, arg3) }

	public static boolean glIsShader(int arg0) { GL20.glIsShader(arg0) }

	public static boolean glIsProgram(int arg0) { GL20.glIsProgram(arg0) }

	public static void glCompileShader(int arg0) { GL20.glCompileShader(arg0) }

	public static void glUniform1i(int arg0, int arg1) { GL20.glUniform1i(arg0, arg1) }

	public static void glUniform2i(int arg0, int arg1, int arg2) { GL20.glUniform2i(arg0, arg1, arg2) }

	public static int glCreateShader(int arg0) { GL20.glCreateShader(arg0) }

	public static void glUniform2f(int arg0, float arg1, float arg2) { GL20.glUniform2f(arg0, arg1, arg2) }

	public static int glCreateProgram() { GL20.glCreateProgram() }

	public static void glUniform3i(int arg0, int arg1, int arg2, int arg3) { GL20.glUniform3i(arg0, arg1, arg2, arg3) }

	public static void glUniform4f(int arg0, float arg1, float arg2, float arg3, float arg4) { GL20.glUniform4f(arg0, arg1, arg2, arg3, arg4) }

	public static void glAttachShader(int arg0, int arg1) { GL20.glAttachShader(arg0, arg1) }

	public static void glDetachShader(int arg0, int arg1) { GL20.glDetachShader(arg0, arg1) }

	public static void glLinkProgram(int arg0) { GL20.glLinkProgram(arg0) }

	public static void glDeleteShader(int arg0) { GL20.glDeleteShader(arg0) }

	public static void glDeleteProgram(int arg0) { GL20.glDeleteProgram(arg0) }

	public static int glGetQueryObjecti(int arg0, int arg1) { GL15.glGetQueryObjecti(arg0, arg1) }

	public static int glGetBufferParameteri(int arg0, int arg1) { GL15.glGetBufferParameteri(arg0, arg1) }

	public static void glGetBufferSubData(int arg0, long arg1, ShortBuffer arg2) { GL15.glGetBufferSubData(arg0, arg1, arg2) }

	public static void glGetBufferSubData(int arg0, long arg1, ByteBuffer arg2) { GL15.glGetBufferSubData(arg0, arg1, arg2) }

	public static void glGetBufferSubData(int arg0, long arg1, IntBuffer arg2) { GL15.glGetBufferSubData(arg0, arg1, arg2) }

	public static void glGetBufferSubData(int arg0, long arg1, FloatBuffer arg2) { GL15.glGetBufferSubData(arg0, arg1, arg2) }

	public static void glGetBufferSubData(int arg0, long arg1, DoubleBuffer arg2) { GL15.glGetBufferSubData(arg0, arg1, arg2) }

	public static ByteBuffer glGetBufferPointer(int arg0, int arg1) { GL15.glGetBufferPointer(arg0, arg1) }

	public static int glGetQueryObjectui(int arg0, int arg1) { GL15.glGetQueryObjectui(arg0, arg1) }

	public static void glGetQueryObject(int arg0, int arg1, IntBuffer arg2) { GL15.glGetQueryObject(arg0, arg1, arg2) }

	public static void glGetQueryObjectu(int arg0, int arg1, IntBuffer arg2) { GL15.glGetQueryObjectu(arg0, arg1, arg2) }

	public static void glGetBufferParameter(int arg0, int arg1, IntBuffer arg2) { GL15.glGetBufferParameter(arg0, arg1, arg2) }

	public static void glEndQuery(int arg0) { GL15.glEndQuery(arg0) }

	public static boolean glIsBuffer(int arg0) { GL15.glIsBuffer(arg0) }

	public static int glGenBuffers() { GL15.glGenBuffers() }

	public static void glGenBuffers(IntBuffer arg0) { GL15.glGenBuffers(arg0) }

	public static void glBufferSubData(int arg0, long arg1, DoubleBuffer arg2) { GL15.glBufferSubData(arg0, arg1, arg2) }

	public static void glBufferSubData(int arg0, long arg1, IntBuffer arg2) { GL15.glBufferSubData(arg0, arg1, arg2) }

	public static void glBufferSubData(int arg0, long arg1, ShortBuffer arg2) { GL15.glBufferSubData(arg0, arg1, arg2) }

	public static void glBufferSubData(int arg0, long arg1, ByteBuffer arg2) { GL15.glBufferSubData(arg0, arg1, arg2) }

	public static void glBufferSubData(int arg0, long arg1, FloatBuffer arg2) { GL15.glBufferSubData(arg0, arg1, arg2) }

	public static boolean glUnmapBuffer(int arg0) { GL15.glUnmapBuffer(arg0) }

	public static ByteBuffer glMapBuffer(int arg0, int arg1, long arg2, ByteBuffer arg3) { GL15.glMapBuffer(arg0, arg1, arg2, arg3) }

	public static ByteBuffer glMapBuffer(int arg0, int arg1, ByteBuffer arg2) { GL15.glMapBuffer(arg0, arg1, arg2) }

	public static void glBeginQuery(int arg0, int arg1) { GL15.glBeginQuery(arg0, arg1) }

	public static int glGenQueries() { GL15.glGenQueries() }

	public static void glGenQueries(IntBuffer arg0) { GL15.glGenQueries(arg0) }

	public static void glDeleteBuffers(IntBuffer arg0) { GL15.glDeleteBuffers(arg0) }

	public static void glDeleteBuffers(int arg0) { GL15.glDeleteBuffers(arg0) }

	public static int glGetQuery(int arg0, int arg1) { GL15.glGetQuery(arg0, arg1) }

	public static void glGetQuery(int arg0, int arg1, IntBuffer arg2) { GL15.glGetQuery(arg0, arg1, arg2) }

	public static int glGetQueryi(int arg0, int arg1) { GL15.glGetQueryi(arg0, arg1) }

	public static boolean glIsQuery(int arg0) { GL15.glIsQuery(arg0) }

	public static void glBindBuffer(int arg0, int arg1) { GL15.glBindBuffer(arg0, arg1) }

	public static void glBufferData(int arg0, FloatBuffer arg1, int arg2) { GL15.glBufferData(arg0, arg1, arg2) }

	public static void glBufferData(int arg0, ShortBuffer arg1, int arg2) { GL15.glBufferData(arg0, arg1, arg2) }

	public static void glBufferData(int arg0, IntBuffer arg1, int arg2) { GL15.glBufferData(arg0, arg1, arg2) }

	public static void glBufferData(int arg0, DoubleBuffer arg1, int arg2) { GL15.glBufferData(arg0, arg1, arg2) }

	public static void glBufferData(int arg0, ByteBuffer arg1, int arg2) { GL15.glBufferData(arg0, arg1, arg2) }

	public static void glBufferData(int arg0, long arg1, int arg2) { GL15.glBufferData(arg0, arg1, arg2) }

	public static void glDeleteQueries(int arg0) { GL15.glDeleteQueries(arg0) }

	public static void glDeleteQueries(IntBuffer arg0) { GL15.glDeleteQueries(arg0) }

	public static void glMultiDrawArrays(int arg0, IntBuffer arg1, IntBuffer arg2) { GL14.glMultiDrawArrays(arg0, arg1, arg2) }

	public static void glFogCoordPointer(int arg0, int arg1, long arg2) { GL14.glFogCoordPointer(arg0, arg1, arg2) }

	public static void glFogCoordPointer(int arg0, FloatBuffer arg1) { GL14.glFogCoordPointer(arg0, arg1) }

	public static void glFogCoordPointer(int arg0, DoubleBuffer arg1) { GL14.glFogCoordPointer(arg0, arg1) }

	public static void glSecondaryColor3d(double arg0, double arg1, double arg2) { GL14.glSecondaryColor3d(arg0, arg1, arg2) }

	public static void glSecondaryColorPointer(int arg0, int arg1, int arg2, long arg3) { GL14.glSecondaryColorPointer(arg0, arg1, arg2, arg3) }

	public static void glSecondaryColorPointer(int arg0, boolean arg1, int arg2, ByteBuffer arg3) { GL14.glSecondaryColorPointer(arg0, arg1, arg2, arg3) }

	public static void glSecondaryColorPointer(int arg0, int arg1, DoubleBuffer arg2) { GL14.glSecondaryColorPointer(arg0, arg1, arg2) }

	public static void glSecondaryColorPointer(int arg0, int arg1, FloatBuffer arg2) { GL14.glSecondaryColorPointer(arg0, arg1, arg2) }

	public static void glSecondaryColor3b(byte arg0, byte arg1, byte arg2) { GL14.glSecondaryColor3b(arg0, arg1, arg2) }

	public static void glBlendFuncSeparate(int arg0, int arg1, int arg2, int arg3) { GL14.glBlendFuncSeparate(arg0, arg1, arg2, arg3) }

	public static void glSecondaryColor3ub(byte arg0, byte arg1, byte arg2) { GL14.glSecondaryColor3ub(arg0, arg1, arg2) }

	public static void glPointParameteri(int arg0, int arg1) { GL14.glPointParameteri(arg0, arg1) }

	public static void glPointParameterf(int arg0, float arg1) { GL14.glPointParameterf(arg0, arg1) }

	public static void glSecondaryColor3f(float arg0, float arg1, float arg2) { GL14.glSecondaryColor3f(arg0, arg1, arg2) }

	public static void glWindowPos2d(double arg0, double arg1) { GL14.glWindowPos2d(arg0, arg1) }

	public static void glBlendColor(float arg0, float arg1, float arg2, float arg3) { GL14.glBlendColor(arg0, arg1, arg2, arg3) }

	public static void glFogCoordf(float arg0) { GL14.glFogCoordf(arg0) }

	public static void glFogCoordd(double arg0) { GL14.glFogCoordd(arg0) }

	public static void glWindowPos3f(float arg0, float arg1, float arg2) { GL14.glWindowPos3f(arg0, arg1, arg2) }

	public static void glWindowPos2f(float arg0, float arg1) { GL14.glWindowPos2f(arg0, arg1) }

	public static void glPointParameter(int arg0, FloatBuffer arg1) { GL14.glPointParameter(arg0, arg1) }

	public static void glPointParameter(int arg0, IntBuffer arg1) { GL14.glPointParameter(arg0, arg1) }

	public static void glWindowPos2i(int arg0, int arg1) { GL14.glWindowPos2i(arg0, arg1) }

	public static void glBlendEquation(int arg0) { GL14.glBlendEquation(arg0) }

	public static void glWindowPos3d(double arg0, double arg1, double arg2) { GL14.glWindowPos3d(arg0, arg1, arg2) }

	public static void glWindowPos3i(int arg0, int arg1, int arg2) { GL14.glWindowPos3i(arg0, arg1, arg2) }

	public static void glMultiTexCoord3d(int arg0, double arg1, double arg2, double arg3) { GL13.glMultiTexCoord3d(arg0, arg1, arg2, arg3) }

	public static void glGetCompressedTexImage(int arg0, int arg1, ByteBuffer arg2) { GL13.glGetCompressedTexImage(arg0, arg1, arg2) }

	public static void glGetCompressedTexImage(int arg0, int arg1, ShortBuffer arg2) { GL13.glGetCompressedTexImage(arg0, arg1, arg2) }

	public static void glGetCompressedTexImage(int arg0, int arg1, IntBuffer arg2) { GL13.glGetCompressedTexImage(arg0, arg1, arg2) }

	public static void glGetCompressedTexImage(int arg0, int arg1, long arg2) { GL13.glGetCompressedTexImage(arg0, arg1, arg2) }

	public static void glCompressedTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) { GL13.glCompressedTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glCompressedTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, ByteBuffer arg5) { GL13.glCompressedTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glCompressedTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) { GL13.glCompressedTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glCompressedTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, ByteBuffer arg7) { GL13.glCompressedTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glCompressedTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) { GL13.glCompressedTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glClientActiveTexture(int arg0) { GL13.glClientActiveTexture(arg0) }

	public static void glCompressedTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) { GL13.glCompressedTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glCompressedTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, ByteBuffer arg7) { GL13.glCompressedTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glCompressedTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) { GL13.glCompressedTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glCompressedTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) { GL13.glCompressedTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glCompressedTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, ByteBuffer arg5) { GL13.glCompressedTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glMultiTexCoord3f(int arg0, float arg1, float arg2, float arg3) { GL13.glMultiTexCoord3f(arg0, arg1, arg2, arg3) }

	public static void glLoadTransposeMatrix(DoubleBuffer arg0) { GL13.glLoadTransposeMatrix(arg0) }

	public static void glLoadTransposeMatrix(FloatBuffer arg0) { GL13.glLoadTransposeMatrix(arg0) }

	public static void glMultTransposeMatrix(FloatBuffer arg0) { GL13.glMultTransposeMatrix(arg0) }

	public static void glMultTransposeMatrix(DoubleBuffer arg0) { GL13.glMultTransposeMatrix(arg0) }

	public static void glMultiTexCoord1d(int arg0, double arg1) { GL13.glMultiTexCoord1d(arg0, arg1) }

	public static void glMultiTexCoord4f(int arg0, float arg1, float arg2, float arg3, float arg4) { GL13.glMultiTexCoord4f(arg0, arg1, arg2, arg3, arg4) }

	public static void glMultiTexCoord2f(int arg0, float arg1, float arg2) { GL13.glMultiTexCoord2f(arg0, arg1, arg2) }

	public static void glCompressedTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, long arg10) { GL13.glCompressedTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glCompressedTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, ByteBuffer arg9) { GL13.glCompressedTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static void glMultiTexCoord1f(int arg0, float arg1) { GL13.glMultiTexCoord1f(arg0, arg1) }

	public static void glMultiTexCoord2d(int arg0, double arg1, double arg2) { GL13.glMultiTexCoord2d(arg0, arg1, arg2) }

	public static void glCompressedTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, long arg7) { GL13.glCompressedTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glCompressedTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ByteBuffer arg6) { GL13.glCompressedTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glCompressedTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) { GL13.glCompressedTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glMultiTexCoord4d(int arg0, double arg1, double arg2, double arg3, double arg4) { GL13.glMultiTexCoord4d(arg0, arg1, arg2, arg3, arg4) }

	public static void glSampleCoverage(float arg0, boolean arg1) { GL13.glSampleCoverage(arg0, arg1) }

	public static void glActiveTexture(int arg0) { GL13.glActiveTexture(arg0) }

	public static void glCopyTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) { GL12.glCopyTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glDrawRangeElements(int arg0, int arg1, int arg2, ByteBuffer arg3) { GL12.glDrawRangeElements(arg0, arg1, arg2, arg3) }

	public static void glDrawRangeElements(int arg0, int arg1, int arg2, int arg3, int arg4, long arg5) { GL12.glDrawRangeElements(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glDrawRangeElements(int arg0, int arg1, int arg2, IntBuffer arg3) { GL12.glDrawRangeElements(arg0, arg1, arg2, arg3) }

	public static void glDrawRangeElements(int arg0, int arg1, int arg2, ShortBuffer arg3) { GL12.glDrawRangeElements(arg0, arg1, arg2, arg3) }

	public static void glTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, ByteBuffer arg9) { GL12.glTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static void glTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, long arg9) { GL12.glTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static void glTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, DoubleBuffer arg9) { GL12.glTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static void glTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, FloatBuffer arg9) { GL12.glTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static void glTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, IntBuffer arg9) { GL12.glTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static void glTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, ShortBuffer arg9) { GL12.glTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static void glTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, DoubleBuffer arg10) { GL12.glTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, long arg10) { GL12.glTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, ByteBuffer arg10) { GL12.glTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, FloatBuffer arg10) { GL12.glTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, IntBuffer arg10) { GL12.glTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static void glTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, ShortBuffer arg10) { GL12.glTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) }

	public static int glGetTexEnvi(int arg0, int arg1) { GL11.glGetTexEnvi(arg0, arg1) }

	public static void glGetPixelMap(int arg0, FloatBuffer arg1) { GL11.glGetPixelMap(arg0, arg1) }

	public static boolean glIsEnabled(int arg0) { GL11.glIsEnabled(arg0) }

	public static void glClearStencil(int arg0) { GL11.glClearStencil(arg0) }

	public static void glMapGrid1d(int arg0, double arg1, double arg2) { GL11.glMapGrid1d(arg0, arg1, arg2) }

	public static void glEvalCoord2d(double arg0, double arg1) { GL11.glEvalCoord2d(arg0, arg1) }

	public static void glFrontFace(int arg0) { GL11.glFrontFace(arg0) }

	public static void glGetLight(int arg0, int arg1, IntBuffer arg2) { GL11.glGetLight(arg0, arg1, arg2) }

	public static void glGetLight(int arg0, int arg1, FloatBuffer arg2) { GL11.glGetLight(arg0, arg1, arg2) }

	public static void glGetPixelMapuiv(int arg0, long arg1) { GL11.glGetPixelMapuiv(arg0, arg1) }

	public static void glFrustum(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5) { GL11.glFrustum(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glFeedbackBuffer(int arg0, FloatBuffer arg1) { GL11.glFeedbackBuffer(arg0, arg1) }

	public static void glGetBoolean(int arg0, ByteBuffer arg1) { GL11.glGetBoolean(arg0, arg1) }

	public static boolean glGetBoolean(int arg0) { GL11.glGetBoolean(arg0) }

	public static float glGetFloat(int arg0) { GL11.glGetFloat(arg0) }

	public static void glGetFloat(int arg0, FloatBuffer arg1) { GL11.glGetFloat(arg0, arg1) }

	public static void glDepthMask(boolean arg0) { GL11.glDepthMask(arg0) }

	public static void glGenTextures(IntBuffer arg0) { GL11.glGenTextures(arg0) }

	public static int glGenTextures() { GL11.glGenTextures() }

	public static void glClipPlane(int arg0, DoubleBuffer arg1) { GL11.glClipPlane(arg0, arg1) }

	public static void glEvalCoord2f(float arg0, float arg1) { GL11.glEvalCoord2f(arg0, arg1) }

	public static void glDisable(int arg0) { GL11.glDisable(arg0) }

	public static void glDrawBuffer(int arg0) { GL11.glDrawBuffer(arg0) }

	public static void glEvalCoord1d(double arg0) { GL11.glEvalCoord1d(arg0) }

	public static String glGetString(int arg0) { GL11.glGetString(arg0) }

	public static void glGetPixelMapfv(int arg0, long arg1) { GL11.glGetPixelMapfv(arg0, arg1) }

	public static void glGetTexImage(int arg0, int arg1, int arg2, int arg3, long arg4) { GL11.glGetTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTexImage(int arg0, int arg1, int arg2, int arg3, ShortBuffer arg4) { GL11.glGetTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTexImage(int arg0, int arg1, int arg2, int arg3, DoubleBuffer arg4) { GL11.glGetTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTexImage(int arg0, int arg1, int arg2, int arg3, FloatBuffer arg4) { GL11.glGetTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTexImage(int arg0, int arg1, int arg2, int arg3, ByteBuffer arg4) { GL11.glGetTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetTexImage(int arg0, int arg1, int arg2, int arg3, IntBuffer arg4) { GL11.glGetTexImage(arg0, arg1, arg2, arg3, arg4) }

	public static void glGetMaterial(int arg0, int arg1, IntBuffer arg2) { GL11.glGetMaterial(arg0, arg1, arg2) }

	public static void glGetMaterial(int arg0, int arg1, FloatBuffer arg2) { GL11.glGetMaterial(arg0, arg1, arg2) }

	public static void glGetTexGen(int arg0, int arg1, IntBuffer arg2) { GL11.glGetTexGen(arg0, arg1, arg2) }

	public static void glGetTexGen(int arg0, int arg1, FloatBuffer arg2) { GL11.glGetTexGen(arg0, arg1, arg2) }

	public static void glGetTexGen(int arg0, int arg1, DoubleBuffer arg2) { GL11.glGetTexGen(arg0, arg1, arg2) }

	public static void glGetTexEnv(int arg0, int arg1, FloatBuffer arg2) { GL11.glGetTexEnv(arg0, arg1, arg2) }

	public static void glGetTexEnv(int arg0, int arg1, IntBuffer arg2) { GL11.glGetTexEnv(arg0, arg1, arg2) }

	public static void glGetMap(int arg0, int arg1, IntBuffer arg2) { GL11.glGetMap(arg0, arg1, arg2) }

	public static void glGetMap(int arg0, int arg1, FloatBuffer arg2) { GL11.glGetMap(arg0, arg1, arg2) }

	public static void glGetMap(int arg0, int arg1, DoubleBuffer arg2) { GL11.glGetMap(arg0, arg1, arg2) }

	public static void glDepthRange(double arg0, double arg1) { GL11.glDepthRange(arg0, arg1) }

	public static void glMateriali(int arg0, int arg1, int arg2) { GL11.glMateriali(arg0, arg1, arg2) }

	public static double glGetDouble(int arg0) { GL11.glGetDouble(arg0) }

	public static void glGetDouble(int arg0, DoubleBuffer arg1) { GL11.glGetDouble(arg0, arg1) }

	public static void glMaterialf(int arg0, int arg1, float arg2) { GL11.glMaterialf(arg0, arg1, arg2) }

	public static void glDrawElements(int arg0, IntBuffer arg1) { GL11.glDrawElements(arg0, arg1) }

	public static void glDrawElements(int arg0, ByteBuffer arg1) { GL11.glDrawElements(arg0, arg1) }

	public static void glDrawElements(int arg0, int arg1, int arg2, long arg3) { GL11.glDrawElements(arg0, arg1, arg2, arg3) }

	public static void glDrawElements(int arg0, ShortBuffer arg1) { GL11.glDrawElements(arg0, arg1) }

	public static void glDrawElements(int arg0, int arg1, int arg2, ByteBuffer arg3) { GL11.glDrawElements(arg0, arg1, arg2, arg3) }

	public static int glGetTexGeni(int arg0, int arg1) { GL11.glGetTexGeni(arg0, arg1) }

	public static boolean glIsList(int arg0) { GL11.glIsList(arg0) }

	public static void glFogi(int arg0, int arg1) { GL11.glFogi(arg0, arg1) }

	public static float glGetTexGenf(int arg0, int arg1) { GL11.glGetTexGenf(arg0, arg1) }

	public static int glGetError() { GL11.glGetError() }

	public static void glHint(int arg0, int arg1) { GL11.glHint(arg0, arg1) }

	public static double glGetTexGend(int arg0, int arg1) { GL11.glGetTexGend(arg0, arg1) }

	public static void glDepthFunc(int arg0) { GL11.glDepthFunc(arg0) }

	public static void glMaterial(int arg0, int arg1, FloatBuffer arg2) { GL11.glMaterial(arg0, arg1, arg2) }

	public static void glMaterial(int arg0, int arg1, IntBuffer arg2) { GL11.glMaterial(arg0, arg1, arg2) }

	public static void glGetClipPlane(int arg0, DoubleBuffer arg1) { GL11.glGetClipPlane(arg0, arg1) }

	public static float glGetTexEnvf(int arg0, int arg1) { GL11.glGetTexEnvf(arg0, arg1) }

	public static void glGetPixelMapu(int arg0, ShortBuffer arg1) { GL11.glGetPixelMapu(arg0, arg1) }

	public static void glGetPixelMapu(int arg0, IntBuffer arg1) { GL11.glGetPixelMapu(arg0, arg1) }

	public static void glMapGrid1f(int arg0, float arg1, float arg2) { GL11.glMapGrid1f(arg0, arg1, arg2) }

	public static void glFogf(int arg0, float arg1) { GL11.glFogf(arg0, arg1) }

	public static ByteBuffer glGetPointer(int arg0, long arg1) { GL11.glGetPointer(arg0, arg1) }

	public static void glDrawArrays(int arg0, int arg1, int arg2) { GL11.glDrawArrays(arg0, arg1, arg2) }

	public static void glGetInteger(int arg0, IntBuffer arg1) { GL11.glGetInteger(arg0, arg1) }

	public static int glGetInteger(int arg0) { GL11.glGetInteger(arg0) }

	public static int glGenLists(int arg0) { GL11.glGenLists(arg0) }

	public static void glInitNames() { GL11.glInitNames() }

	public static void glFog(int arg0, FloatBuffer arg1) { GL11.glFog(arg0, arg1) }

	public static void glFog(int arg0, IntBuffer arg1) { GL11.glFog(arg0, arg1) }

	public static void glGetPixelMapusv(int arg0, long arg1) { GL11.glGetPixelMapusv(arg0, arg1) }

	public static void glFlush() { GL11.glFlush() }

	public static void glFinish() { GL11.glFinish() }

	public static void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, ByteBuffer arg8) { GL11.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, ShortBuffer arg8) { GL11.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, IntBuffer arg8) { GL11.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, DoubleBuffer arg8) { GL11.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, FloatBuffer arg8) { GL11.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) { GL11.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glLighti(int arg0, int arg1, int arg2) { GL11.glLighti(arg0, arg1, arg2) }

	public static void glPixelMapu(int arg0, ShortBuffer arg1) { GL11.glPixelMapu(arg0, arg1) }

	public static void glPixelMapu(int arg0, IntBuffer arg1) { GL11.glPixelMapu(arg0, arg1) }

	public static void glRasterPos4i(int arg0, int arg1, int arg2, int arg3) { GL11.glRasterPos4i(arg0, arg1, arg2, arg3) }

	public static void glPopAttrib() { GL11.glPopAttrib() }

	public static void glRasterPos3i(int arg0, int arg1, int arg2) { GL11.glRasterPos3i(arg0, arg1, arg2) }

	public static void glPixelMapuiv(int arg0, int arg1, long arg2) { GL11.glPixelMapuiv(arg0, arg1, arg2) }

	public static void glPointSize(float arg0) { GL11.glPointSize(arg0) }

	public static void glRasterPos2f(float arg0, float arg1) { GL11.glRasterPos2f(arg0, arg1) }

	public static void glPixelTransferi(int arg0, int arg1) { GL11.glPixelTransferi(arg0, arg1) }

	public static void glPixelZoom(float arg0, float arg1) { GL11.glPixelZoom(arg0, arg1) }

	public static void glPixelTransferf(int arg0, float arg1) { GL11.glPixelTransferf(arg0, arg1) }

	public static void glRectd(double arg0, double arg1, double arg2, double arg3) { GL11.glRectd(arg0, arg1, arg2, arg3) }

	public static void glNormal3f(float arg0, float arg1, float arg2) { GL11.glNormal3f(arg0, arg1, arg2) }

	public static void glPixelMap(int arg0, FloatBuffer arg1) { GL11.glPixelMap(arg0, arg1) }

	public static void glRotatef(float arg0, float arg1, float arg2, float arg3) { GL11.glRotatef(arg0, arg1, arg2, arg3) }

	public static void glPolygonOffset(float arg0, float arg1) { GL11.glPolygonOffset(arg0, arg1) }

	public static void glPassThrough(float arg0) { GL11.glPassThrough(arg0) }

	public static void glPushName(int arg0) { GL11.glPushName(arg0) }

	public static void glPixelMapfv(int arg0, int arg1, long arg2) { GL11.glPixelMapfv(arg0, arg1, arg2) }

	public static void glNewList(int arg0, int arg1) { GL11.glNewList(arg0, arg1) }

	public static void glScaled(double arg0, double arg1, double arg2) { GL11.glScaled(arg0, arg1, arg2) }

	public static void glMatrixMode(int arg0) { GL11.glMatrixMode(arg0) }

	public static void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, DoubleBuffer arg6) { GL11.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) { GL11.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ShortBuffer arg6) { GL11.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ByteBuffer arg6) { GL11.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, IntBuffer arg6) { GL11.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, FloatBuffer arg6) { GL11.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glNormalPointer(int arg0, ByteBuffer arg1) { GL11.glNormalPointer(arg0, arg1) }

	public static void glNormalPointer(int arg0, DoubleBuffer arg1) { GL11.glNormalPointer(arg0, arg1) }

	public static void glNormalPointer(int arg0, IntBuffer arg1) { GL11.glNormalPointer(arg0, arg1) }

	public static void glNormalPointer(int arg0, int arg1, ByteBuffer arg2) { GL11.glNormalPointer(arg0, arg1, arg2) }

	public static void glNormalPointer(int arg0, int arg1, long arg2) { GL11.glNormalPointer(arg0, arg1, arg2) }

	public static void glNormalPointer(int arg0, FloatBuffer arg1) { GL11.glNormalPointer(arg0, arg1) }

	public static void glRasterPos2d(double arg0, double arg1) { GL11.glRasterPos2d(arg0, arg1) }

	public static void glNormal3b(byte arg0, byte arg1, byte arg2) { GL11.glNormal3b(arg0, arg1, arg2) }

	public static void glScissor(int arg0, int arg1, int arg2, int arg3) { GL11.glScissor(arg0, arg1, arg2, arg3) }

	public static void glRectf(float arg0, float arg1, float arg2, float arg3) { GL11.glRectf(arg0, arg1, arg2, arg3) }

	public static void glPolygonMode(int arg0, int arg1) { GL11.glPolygonMode(arg0, arg1) }

	public static void glRasterPos3f(float arg0, float arg1, float arg2) { GL11.glRasterPos3f(arg0, arg1, arg2) }

	public static boolean glIsTexture(int arg0) { GL11.glIsTexture(arg0) }

	public static void glMultMatrix(DoubleBuffer arg0) { GL11.glMultMatrix(arg0) }

	public static void glMultMatrix(FloatBuffer arg0) { GL11.glMultMatrix(arg0) }

	public static void glPolygonStipple(long arg0) { GL11.glPolygonStipple(arg0) }

	public static void glPolygonStipple(ByteBuffer arg0) { GL11.glPolygonStipple(arg0) }

	public static void glRasterPos4f(float arg0, float arg1, float arg2, float arg3) { GL11.glRasterPos4f(arg0, arg1, arg2, arg3) }

	public static void glOrtho(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5) { GL11.glOrtho(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glNormal3i(int arg0, int arg1, int arg2) { GL11.glNormal3i(arg0, arg1, arg2) }

	public static void glPixelStorei(int arg0, int arg1) { GL11.glPixelStorei(arg0, arg1) }

	public static void glRasterPos2i(int arg0, int arg1) { GL11.glRasterPos2i(arg0, arg1) }

	public static void glNormal3d(double arg0, double arg1, double arg2) { GL11.glNormal3d(arg0, arg1, arg2) }

	public static void glPushAttrib(int arg0) { GL11.glPushAttrib(arg0) }

	public static void glRasterPos3d(double arg0, double arg1, double arg2) { GL11.glRasterPos3d(arg0, arg1, arg2) }

	public static void glRotated(double arg0, double arg1, double arg2, double arg3) { GL11.glRotated(arg0, arg1, arg2, arg3) }

	public static void glLight(int arg0, int arg1, IntBuffer arg2) { GL11.glLight(arg0, arg1, arg2) }

	public static void glLight(int arg0, int arg1, FloatBuffer arg2) { GL11.glLight(arg0, arg1, arg2) }

	public static void glEndList() { GL11.glEndList() }

	public static void glPopMatrix() { GL11.glPopMatrix() }

	public static void glPixelStoref(int arg0, float arg1) { GL11.glPixelStoref(arg0, arg1) }

	public static void glPushMatrix() { GL11.glPushMatrix() }

	public static void glReadBuffer(int arg0) { GL11.glReadBuffer(arg0) }

	public static void glScalef(float arg0, float arg1, float arg2) { GL11.glScalef(arg0, arg1, arg2) }

	public static void glShadeModel(int arg0) { GL11.glShadeModel(arg0) }

	public static int glRenderMode(int arg0) { GL11.glRenderMode(arg0) }

	public static void glRasterPos4d(double arg0, double arg1, double arg2, double arg3) { GL11.glRasterPos4d(arg0, arg1, arg2, arg3) }

	public static void glPopName() { GL11.glPopName() }

	public static void glSelectBuffer(IntBuffer arg0) { GL11.glSelectBuffer(arg0) }

	public static void glPixelMapusv(int arg0, int arg1, long arg2) { GL11.glPixelMapusv(arg0, arg1, arg2) }

	public static void glRecti(int arg0, int arg1, int arg2, int arg3) { GL11.glRecti(arg0, arg1, arg2, arg3) }

	public static void glLoadIdentity() { GL11.glLoadIdentity() }

	public static void glVertex4d(double arg0, double arg1, double arg2, double arg3) { GL11.glVertex4d(arg0, arg1, arg2, arg3) }

	public static void glVertex2i(int arg0, int arg1) { GL11.glVertex2i(arg0, arg1) }

	public static void glTexEnvf(int arg0, int arg1, float arg2) { GL11.glTexEnvf(arg0, arg1, arg2) }

	public static void glListBase(int arg0) { GL11.glListBase(arg0) }

	public static void glStencilOp(int arg0, int arg1, int arg2) { GL11.glStencilOp(arg0, arg1, arg2) }

	public static void glTexParameteri(int arg0, int arg1, int arg2) { GL11.glTexParameteri(arg0, arg1, arg2) }

	public static void glTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, long arg7) { GL11.glTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, DoubleBuffer arg7) { GL11.glTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, ShortBuffer arg7) { GL11.glTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, IntBuffer arg7) { GL11.glTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, FloatBuffer arg7) { GL11.glTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, ByteBuffer arg7) { GL11.glTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glViewport(int arg0, int arg1, int arg2, int arg3) { GL11.glViewport(arg0, arg1, arg2, arg3) }

	public static void glTexCoord2d(double arg0, double arg1) { GL11.glTexCoord2d(arg0, arg1) }

	public static void glTexEnvi(int arg0, int arg1, int arg2) { GL11.glTexEnvi(arg0, arg1, arg2) }

	public static void glTexEnv(int arg0, int arg1, FloatBuffer arg2) { GL11.glTexEnv(arg0, arg1, arg2) }

	public static void glTexEnv(int arg0, int arg1, IntBuffer arg2) { GL11.glTexEnv(arg0, arg1, arg2) }

	public static void glVertex3d(double arg0, double arg1, double arg2) { GL11.glVertex3d(arg0, arg1, arg2) }

	public static void glTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ShortBuffer arg6) { GL11.glTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, IntBuffer arg6) { GL11.glTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, FloatBuffer arg6) { GL11.glTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, DoubleBuffer arg6) { GL11.glTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) { GL11.glTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ByteBuffer arg6) { GL11.glTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glStencilFunc(int arg0, int arg1, int arg2) { GL11.glStencilFunc(arg0, arg1, arg2) }

	public static void glMap1f(int arg0, float arg1, float arg2, int arg3, int arg4, FloatBuffer arg5) { GL11.glMap1f(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glLoadMatrix(FloatBuffer arg0) { GL11.glLoadMatrix(arg0) }

	public static void glLoadMatrix(DoubleBuffer arg0) { GL11.glLoadMatrix(arg0) }

	public static void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) { GL11.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, DoubleBuffer arg8) { GL11.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, ByteBuffer arg8) { GL11.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, ShortBuffer arg8) { GL11.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, FloatBuffer arg8) { GL11.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, IntBuffer arg8) { GL11.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) }

	public static void glVertex4i(int arg0, int arg1, int arg2, int arg3) { GL11.glVertex4i(arg0, arg1, arg2, arg3) }

	public static void glVertex2d(double arg0, double arg1) { GL11.glVertex2d(arg0, arg1) }

	public static void glVertex2f(float arg0, float arg1) { GL11.glVertex2f(arg0, arg1) }

	public static void glTranslatef(float arg0, float arg1, float arg2) { GL11.glTranslatef(arg0, arg1, arg2) }

	public static void glLogicOp(int arg0) { GL11.glLogicOp(arg0) }

	public static void glMap2d(int arg0, double arg1, double arg2, int arg3, int arg4, double arg5, double arg6, int arg7, int arg8, DoubleBuffer arg9) { GL11.glMap2d(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static void glVertex3i(int arg0, int arg1, int arg2) { GL11.glVertex3i(arg0, arg1, arg2) }

	public static void glMap1d(int arg0, double arg1, double arg2, int arg3, int arg4, DoubleBuffer arg5) { GL11.glMap1d(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glLightModeli(int arg0, int arg1) { GL11.glLightModeli(arg0, arg1) }

	public static void glMapGrid2d(int arg0, double arg1, double arg2, int arg3, double arg4, double arg5) { GL11.glMapGrid2d(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glLineStipple(int arg0, short arg1) { GL11.glLineStipple(arg0, arg1) }

	public static void glTexParameterf(int arg0, int arg1, float arg2) { GL11.glTexParameterf(arg0, arg1, arg2) }

	public static void glTexCoord3f(float arg0, float arg1, float arg2) { GL11.glTexCoord3f(arg0, arg1, arg2) }

	public static void glTexGend(int arg0, int arg1, double arg2) { GL11.glTexGend(arg0, arg1, arg2) }

	public static void glLightModelf(int arg0, float arg1) { GL11.glLightModelf(arg0, arg1) }

	public static void glVertexPointer(int arg0, int arg1, ShortBuffer arg2) { GL11.glVertexPointer(arg0, arg1, arg2) }

	public static void glVertexPointer(int arg0, int arg1, int arg2, long arg3) { GL11.glVertexPointer(arg0, arg1, arg2, arg3) }

	public static void glVertexPointer(int arg0, int arg1, IntBuffer arg2) { GL11.glVertexPointer(arg0, arg1, arg2) }

	public static void glVertexPointer(int arg0, int arg1, DoubleBuffer arg2) { GL11.glVertexPointer(arg0, arg1, arg2) }

	public static void glVertexPointer(int arg0, int arg1, FloatBuffer arg2) { GL11.glVertexPointer(arg0, arg1, arg2) }

	public static void glVertexPointer(int arg0, int arg1, int arg2, ByteBuffer arg3) { GL11.glVertexPointer(arg0, arg1, arg2, arg3) }

	public static void glTexCoord4f(float arg0, float arg1, float arg2, float arg3) { GL11.glTexCoord4f(arg0, arg1, arg2, arg3) }

	public static void glMap2f(int arg0, float arg1, float arg2, int arg3, int arg4, float arg5, float arg6, int arg7, int arg8, FloatBuffer arg9) { GL11.glMap2f(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) }

	public static void glTexParameter(int arg0, int arg1, IntBuffer arg2) { GL11.glTexParameter(arg0, arg1, arg2) }

	public static void glTexParameter(int arg0, int arg1, FloatBuffer arg2) { GL11.glTexParameter(arg0, arg1, arg2) }

	public static void glTexCoord1d(double arg0) { GL11.glTexCoord1d(arg0) }

	public static void glTexCoord4d(double arg0, double arg1, double arg2, double arg3) { GL11.glTexCoord4d(arg0, arg1, arg2, arg3) }

	public static void glTexGenf(int arg0, int arg1, float arg2) { GL11.glTexGenf(arg0, arg1, arg2) }

	public static void glLoadName(int arg0) { GL11.glLoadName(arg0) }

	public static void glTexGeni(int arg0, int arg1, int arg2) { GL11.glTexGeni(arg0, arg1, arg2) }

	public static void glMapGrid2f(int arg0, float arg1, float arg2, int arg3, float arg4, float arg5) { GL11.glMapGrid2f(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static void glTexCoord2f(float arg0, float arg1) { GL11.glTexCoord2f(arg0, arg1) }

	public static void glTexCoord1f(float arg0) { GL11.glTexCoord1f(arg0) }

	public static void glLightModel(int arg0, FloatBuffer arg1) { GL11.glLightModel(arg0, arg1) }

	public static void glLightModel(int arg0, IntBuffer arg1) { GL11.glLightModel(arg0, arg1) }

	public static void glTexCoord3d(double arg0, double arg1, double arg2) { GL11.glTexCoord3d(arg0, arg1, arg2) }

	public static void glStencilMask(int arg0) { GL11.glStencilMask(arg0) }

	public static void glTexGen(int arg0, int arg1, IntBuffer arg2) { GL11.glTexGen(arg0, arg1, arg2) }

	public static void glTexGen(int arg0, int arg1, DoubleBuffer arg2) { GL11.glTexGen(arg0, arg1, arg2) }

	public static void glTexGen(int arg0, int arg1, FloatBuffer arg2) { GL11.glTexGen(arg0, arg1, arg2) }

	public static void glVertex3f(float arg0, float arg1, float arg2) { GL11.glVertex3f(arg0, arg1, arg2) }

	public static void glLightf(int arg0, int arg1, float arg2) { GL11.glLightf(arg0, arg1, arg2) }

	public static void glLineWidth(float arg0) { GL11.glLineWidth(arg0) }

	public static void glVertex4f(float arg0, float arg1, float arg2, float arg3) { GL11.glVertex4f(arg0, arg1, arg2, arg3) }

	public static void glTranslated(double arg0, double arg1, double arg2) { GL11.glTranslated(arg0, arg1, arg2) }

	public static void glPopClientAttrib() { GL11.glPopClientAttrib() }

	public static void glPrioritizeTextures(IntBuffer arg0, FloatBuffer arg1) { GL11.glPrioritizeTextures(arg0, arg1) }

	public static void glCopyTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) { GL11.glCopyTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5) }

	public static boolean glAreTexturesResident(IntBuffer arg0, ByteBuffer arg1) { GL11.glAreTexturesResident(arg0, arg1) }

	public static void glEnableClientState(int arg0) { GL11.glEnableClientState(arg0) }

	public static void glGetTexLevelParameter(int arg0, int arg1, int arg2, IntBuffer arg3) { GL11.glGetTexLevelParameter(arg0, arg1, arg2, arg3) }

	public static void glGetTexLevelParameter(int arg0, int arg1, int arg2, FloatBuffer arg3) { GL11.glGetTexLevelParameter(arg0, arg1, arg2, arg3) }

	public static void glPushClientAttrib(int arg0) { GL11.glPushClientAttrib(arg0) }

	public static void glInterleavedArrays(int arg0, int arg1, DoubleBuffer arg2) { GL11.glInterleavedArrays(arg0, arg1, arg2) }

	public static void glInterleavedArrays(int arg0, int arg1, FloatBuffer arg2) { GL11.glInterleavedArrays(arg0, arg1, arg2) }

	public static void glInterleavedArrays(int arg0, int arg1, long arg2) { GL11.glInterleavedArrays(arg0, arg1, arg2) }

	public static void glInterleavedArrays(int arg0, int arg1, ShortBuffer arg2) { GL11.glInterleavedArrays(arg0, arg1, arg2) }

	public static void glInterleavedArrays(int arg0, int arg1, ByteBuffer arg2) { GL11.glInterleavedArrays(arg0, arg1, arg2) }

	public static void glInterleavedArrays(int arg0, int arg1, IntBuffer arg2) { GL11.glInterleavedArrays(arg0, arg1, arg2) }

	public static void glTexCoordPointer(int arg0, int arg1, FloatBuffer arg2) { GL11.glTexCoordPointer(arg0, arg1, arg2) }

	public static void glTexCoordPointer(int arg0, int arg1, IntBuffer arg2) { GL11.glTexCoordPointer(arg0, arg1, arg2) }

	public static void glTexCoordPointer(int arg0, int arg1, DoubleBuffer arg2) { GL11.glTexCoordPointer(arg0, arg1, arg2) }

	public static void glTexCoordPointer(int arg0, int arg1, int arg2, long arg3) { GL11.glTexCoordPointer(arg0, arg1, arg2, arg3) }

	public static void glTexCoordPointer(int arg0, int arg1, ShortBuffer arg2) { GL11.glTexCoordPointer(arg0, arg1, arg2) }

	public static void glTexCoordPointer(int arg0, int arg1, int arg2, ByteBuffer arg3) { GL11.glTexCoordPointer(arg0, arg1, arg2, arg3) }

	public static void glGetTexParameter(int arg0, int arg1, FloatBuffer arg2) { GL11.glGetTexParameter(arg0, arg1, arg2) }

	public static void glGetTexParameter(int arg0, int arg1, IntBuffer arg2) { GL11.glGetTexParameter(arg0, arg1, arg2) }

	public static float glGetTexLevelParameterf(int arg0, int arg1, int arg2) { GL11.glGetTexLevelParameterf(arg0, arg1, arg2) }

	public static float glGetTexParameterf(int arg0, int arg1) { GL11.glGetTexParameterf(arg0, arg1) }

	public static int glGetTexLevelParameteri(int arg0, int arg1, int arg2) { GL11.glGetTexLevelParameteri(arg0, arg1, arg2) }

	public static int glGetTexParameteri(int arg0, int arg1) { GL11.glGetTexParameteri(arg0, arg1) }

	public static void glGetPolygonStipple(long arg0) { GL11.glGetPolygonStipple(arg0) }

	public static void glGetPolygonStipple(ByteBuffer arg0) { GL11.glGetPolygonStipple(arg0) }

	public static void glEdgeFlagPointer(int arg0, ByteBuffer arg1) { GL11.glEdgeFlagPointer(arg0, arg1) }

	public static void glEdgeFlagPointer(int arg0, long arg1) { GL11.glEdgeFlagPointer(arg0, arg1) }

	public static void glCopyTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) { GL11.glCopyTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glDisableClientState(int arg0) { GL11.glDisableClientState(arg0) }

	public static void glClearColor(float arg0, float arg1, float arg2, float arg3) { GL11.glClearColor(arg0, arg1, arg2, arg3) }

	public static void glDeleteTextures(int arg0) { GL11.glDeleteTextures(arg0) }

	public static void glDeleteTextures(IntBuffer arg0) { GL11.glDeleteTextures(arg0) }

	public static void glAlphaFunc(int arg0, float arg1) { GL11.glAlphaFunc(arg0, arg1) }

	public static void glEvalCoord1f(float arg0) { GL11.glEvalCoord1f(arg0) }

	public static void glColor4f(float arg0, float arg1, float arg2, float arg3) { GL11.glColor4f(arg0, arg1, arg2, arg3) }

	public static void glEnd() { GL11.glEnd() }

	public static void glEvalPoint1(int arg0) { GL11.glEvalPoint1(arg0) }

	public static void glDeleteLists(int arg0, int arg1) { GL11.glDeleteLists(arg0, arg1) }

	public static void glBindTexture(int arg0, int arg1) { GL11.glBindTexture(arg0, arg1) }

	public static void glCallList(int arg0) { GL11.glCallList(arg0) }

	public static void glAccum(int arg0, float arg1) { GL11.glAccum(arg0, arg1) }

	public static void glColorMaterial(int arg0, int arg1) { GL11.glColorMaterial(arg0, arg1) }

	public static void glCopyTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) { GL11.glCopyTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glColor4d(double arg0, double arg1, double arg2, double arg3) { GL11.glColor4d(arg0, arg1, arg2, arg3) }

	public static void glColorMask(boolean arg0, boolean arg1, boolean arg2, boolean arg3) { GL11.glColorMask(arg0, arg1, arg2, arg3) }

	public static void glColor3ub(byte arg0, byte arg1, byte arg2) { GL11.glColor3ub(arg0, arg1, arg2) }

	public static void glEdgeFlag(boolean arg0) { GL11.glEdgeFlag(arg0) }

	public static void glClearAccum(float arg0, float arg1, float arg2, float arg3) { GL11.glClearAccum(arg0, arg1, arg2, arg3) }

	public static void glDrawPixels(int arg0, int arg1, int arg2, int arg3, ByteBuffer arg4) { GL11.glDrawPixels(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawPixels(int arg0, int arg1, int arg2, int arg3, long arg4) { GL11.glDrawPixels(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawPixels(int arg0, int arg1, int arg2, int arg3, IntBuffer arg4) { GL11.glDrawPixels(arg0, arg1, arg2, arg3, arg4) }

	public static void glDrawPixels(int arg0, int arg1, int arg2, int arg3, ShortBuffer arg4) { GL11.glDrawPixels(arg0, arg1, arg2, arg3, arg4) }

	public static void glClearDepth(double arg0) { GL11.glClearDepth(arg0) }

	public static void glCopyTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) { GL11.glCopyTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7) }

	public static void glEvalMesh2(int arg0, int arg1, int arg2, int arg3, int arg4) { GL11.glEvalMesh2(arg0, arg1, arg2, arg3, arg4) }

	public static void glEnable(int arg0) { GL11.glEnable(arg0) }

	public static void glColor3d(double arg0, double arg1, double arg2) { GL11.glColor3d(arg0, arg1, arg2) }

	public static void glColor4b(byte arg0, byte arg1, byte arg2, byte arg3) { GL11.glColor4b(arg0, arg1, arg2, arg3) }

	public static void glBlendFunc(int arg0, int arg1) { GL11.glBlendFunc(arg0, arg1) }

	public static void glColor3f(float arg0, float arg1, float arg2) { GL11.glColor3f(arg0, arg1, arg2) }

	public static void glColor3b(byte arg0, byte arg1, byte arg2) { GL11.glColor3b(arg0, arg1, arg2) }

	public static void glEvalMesh1(int arg0, int arg1, int arg2) { GL11.glEvalMesh1(arg0, arg1, arg2) }

	public static void glCopyPixels(int arg0, int arg1, int arg2, int arg3, int arg4) { GL11.glCopyPixels(arg0, arg1, arg2, arg3, arg4) }

	public static void glClear(int arg0) { GL11.glClear(arg0) }

	public static void glCallLists(IntBuffer arg0) { GL11.glCallLists(arg0) }

	public static void glCallLists(ShortBuffer arg0) { GL11.glCallLists(arg0) }

	public static void glCallLists(ByteBuffer arg0) { GL11.glCallLists(arg0) }

	public static void glEvalPoint2(int arg0, int arg1) { GL11.glEvalPoint2(arg0, arg1) }

	public static void glColor4ub(byte arg0, byte arg1, byte arg2, byte arg3) { GL11.glColor4ub(arg0, arg1, arg2, arg3) }

	public static void glBitmap(int arg0, int arg1, float arg2, float arg3, float arg4, float arg5, ByteBuffer arg6) { GL11.glBitmap(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glBitmap(int arg0, int arg1, float arg2, float arg3, float arg4, float arg5, long arg6) { GL11.glBitmap(arg0, arg1, arg2, arg3, arg4, arg5, arg6) }

	public static void glBegin(int arg0) { GL11.glBegin(arg0) }

	public static void glColorPointer(int arg0, int arg1, int arg2, long arg3) { GL11.glColorPointer(arg0, arg1, arg2, arg3) }

	public static void glColorPointer(int arg0, int arg1, int arg2, ByteBuffer arg3) { GL11.glColorPointer(arg0, arg1, arg2, arg3) }

	public static void glColorPointer(int arg0, int arg1, FloatBuffer arg2) { GL11.glColorPointer(arg0, arg1, arg2) }

	public static void glColorPointer(int arg0, int arg1, DoubleBuffer arg2) { GL11.glColorPointer(arg0, arg1, arg2) }

	public static void glColorPointer(int arg0, boolean arg1, int arg2, ByteBuffer arg3) { GL11.glColorPointer(arg0, arg1, arg2, arg3) }

	public static void glCullFace(int arg0) { GL11.glCullFace(arg0) }

	public static void glArrayElement(int arg0) { GL11.glArrayElement(arg0) }


}