  # Emitting class Main {...}
    # Emitting void main(...) {...}
.globl _main
_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 5
          # Emitting i0
          # Emitting 5
          movl $5, %esi
        movl %esi, 0(%edi)
        # Emitting i1 = read()
          # Emitting i1
          # Emitting read()
          pushl %esp
          call _scanf
          movl 0(%esp), %edi
        movl %edi, 0(%esi)
        # Emitting r1 = (i0 + i1)
          # Emitting r1
          # Emitting (i0 + i1)
            # Emitting i0
            # Emitting i1
          pushl %esi
          pushl %edx
          movl 4(%esp), %esi
          addl 0(%esp), %esi
        movl %esi, 0(%edi)
        # Emitting write(r1)
