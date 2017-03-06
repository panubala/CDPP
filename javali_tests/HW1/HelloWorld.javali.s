  # Emitting class Main {...}
    # Emitting void main(...) {...}
.globl _main
_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting x = 5
          # Emitting x
          # Emitting 5
          movl $5, %esi
        movl %esi, 0(%edi)
    movl $0, %eax
    leave
    ret
